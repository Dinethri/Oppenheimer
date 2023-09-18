package dataaccess;

import config.DBConnection;
import model.Hero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Repository {

    private static final String SQL_GET_BY_ID = "SELECT * FROM working_class_heroes WHERE natid = ?";

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public Hero getUserById(String natid) {

        Hero hero = new Hero();
        try {
            connection = DBConnection.getInstance();

            preparedStatement = connection.prepareStatement(SQL_GET_BY_ID);
            preparedStatement.setString(1, natid);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                hero.setNatid(resultSet.getString("natid"));
                hero.setName(resultSet.getString("name"));
                hero.setGender(resultSet.getString("gender"));
                hero.setBirthDate(resultSet.getString("birth_date"));
                hero.setDeathDate(resultSet.getString("death_date"));
                hero.setSalary(resultSet.getDouble("salary"));
                hero.setTaxPaid(resultSet.getDouble("tax_paid"));
                hero.setBrowniePoints(resultSet.getDouble("brownie_points"));

                return hero;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return hero;
    }
}
