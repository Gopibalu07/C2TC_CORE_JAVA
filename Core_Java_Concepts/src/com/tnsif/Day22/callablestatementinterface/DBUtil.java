package com.tnsif.Day22.callablestatementinterface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

    private static final String DB_DRIVER_CLASS = "driver.class.name";
    private static final String DB_USERNAME = "db_username";
    private static final String DB_PASSWORD = "db_password";
    private static final String DB_URL = "db.url";

    private static Connection connection = null;
    private static Properties properties = null;

    static {
        try {
            properties = new Properties();

            // Load properties file from classpath
            try (InputStream input = DBUtil.class.getClassLoader().getResourceAsStream("database.properties")) {
                if (input == null) {
                    throw new FileNotFoundException("Property file 'database.properties' not found in classpath");
                }
                properties.load(input);
            }

            // Load JDBC driver
            Class.forName(properties.getProperty(DB_DRIVER_CLASS));

            // Establish connection
            connection = DriverManager.getConnection(
                    properties.getProperty(DB_URL),
                    properties.getProperty(DB_USERNAME),
                    properties.getProperty(DB_PASSWORD)
            );

            System.out.println("✅ Database connection established successfully!");

        } catch (FileNotFoundException e) {
            System.err.println("❌ database.properties file not found. Place it under src folder or classpath.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("❌ Error reading database.properties file.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("❌ JDBC Driver not found. Check driver.class.name in database.properties.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Failed to connect to database. Check URL, username, or password.");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
