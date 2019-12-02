package coom.bz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static Connection connection;

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/kamal", "root", "azerroot");
            System.out.println("successul connection");
        } catch (Exception e) {
            System.out.println(e.getMessage() + "here");
        }
        return connection;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
}
