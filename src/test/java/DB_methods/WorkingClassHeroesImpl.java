package DB_methods;

import Config.DBConnection;
import io.restassured.response.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkingClassHeroesImpl {

    private static final String GET_BY_ID= "SELECT * FROM working_class_heroes WHERE natid = ?";
    public Response getUserById(String userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBConnection.getInstance();

            // Define the SQL query with a placeholder for the ID
            String sql = GET_BY_ID;

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userId); // Set the ID value

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Extract data from the result set and create an instance of YourDataModel
                int fetchedId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                // ... other columns

                // Create an instance of YourDataModel with the retrieved data
//                YourDataModel data = new YourDataModel(fetchedId, name /* other data */);
                System.out.println(resultSet);
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources in a finally block
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
