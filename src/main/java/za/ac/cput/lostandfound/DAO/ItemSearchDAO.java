package za.ac.cput.lostandfound.connection;

import za.ac.cput.lostandfound.domain.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//get more info on db setup 
 /*
 * @author jburns
 */
public class ItemSearchDAO {

    public List<Item> searchItems(String category, String model, String colour, String location) {
        List<Item> results = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT * FROM item WHERE 1=1");
        List<String> params = new ArrayList<>();

        if (isSelected(category)) {
            sql.append(" AND category = ?");
            params.add(category);
        }
        if (isSelected(model)) {
            sql.append(" AND model = ?");
            params.add(model);
        }
        if (isSelected(colour)) {
            sql.append(" AND colour = ?");
            params.add(colour);
        }
        if (isSelected(location)) {
            sql.append(" AND location = ?");
            params.add(location);
        }

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            for (int i = 0; i < params.size(); i++) {
                stmt.setString(i + 1, params.get(i));
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Item item = new Item(
                            rs.getInt("id"),
                            rs.getString("category"),
                            rs.getString("model"),              //Item.java
                            rs.getString("colour"),
                            rs.getString("location") //more complex DB query required for location!!
                    );
                    results.add(item);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    private boolean isSelected(String value) {
        return value != null && !value.isBlank() && !value.equalsIgnoreCase("Any");
    }
}

//unfinished proof of concept for submission
