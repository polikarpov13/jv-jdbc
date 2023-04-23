package mate.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can not load JDBC driver for MySQL! ", e);
        }
    }

    public static Connection getConnection() {
        try {
            Properties dbProperties = new Properties();
            dbProperties.put("user", "root");
            dbProperties.put("password", "Barec20082004");

            return DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/taxi_service_db", dbProperties);
        } catch (SQLException e) {
            throw new RuntimeException("Can not create connection to DB", e);
        }
    }
}