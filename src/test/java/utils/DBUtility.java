package utils;
import java.io.IOException;
import java.sql.*;

public class DBUtility {
        private static Connection connection;
        private static Statement statement;
        private static ResultSet resultSet;

        public static void connectToDB() {
            try {
                connection = DriverManager.getConnection(
                        ConfigReader.get("dbUrl"),
                        ConfigReader.get("dbUsername"),
                        ConfigReader.get("dbPassword")
                );
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to connect to DB");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static ResultSet executeQuery(String query) {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(query);
                return resultSet;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Query failed: " + query);
            }
        }

        public static void closeConnection() {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

