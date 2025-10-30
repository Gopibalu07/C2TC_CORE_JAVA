package com.tnsif.Day22.callablestatementinterface;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UsingCallableStmt {

    private static CallableStatement cs = null;
    private static Statement st = null;
    private static Connection connection;

    // Static block to establish connection once
    static {
        connection = DBUtil.getConnection();
        if (connection != null)
            System.out.println("✅ JDBC: Connection established successfully.");
        else
            System.err.println("❌ JDBC: Connection failed.");
    }

    // Create stored procedure in PostgreSQL
    static int createProcedure1() {
        int n = 0;
        try {
            String sql = """
                CREATE OR REPLACE PROCEDURE addemployee(
                    IN emp_id INT,
                    IN emp_name VARCHAR,
                    IN emp_salary DOUBLE PRECISION
                )
                LANGUAGE plpgsql
                AS $$
                BEGIN
                    INSERT INTO employee_tb (id, name, salary)
                    VALUES (emp_id, emp_name, emp_salary);
                END;
                $$;
                """;

            st = connection.createStatement();
            st.execute(sql);
            System.out.println("✅ Procedure 'addemployee' created successfully.");
            n = 1;

        } catch (SQLException e) {
            System.err.println("⚠️ Error creating procedure: " + e.getMessage());
        }
        return n;
    }

    // Call the stored procedure
    static int callProcedure1(int id, String name, double salary) {
        int n = 0;
        try {
            // PostgreSQL requires CALL, not {call ...}
            cs = connection.prepareCall("CALL addemployee(?, ?, ?)");
            cs.setInt(1, id);
            cs.setString(2, name);
            cs.setDouble(3, salary);
            cs.execute();
            System.out.println("✅ Procedure executed successfully for: " + name);
            n = 1;

        } catch (SQLException e) {
            System.err.println("❌ Error executing procedure: " + e.getMessage());
        }
        return n;
    }

    // Close all resources
    static void closeConnection() {
        try {
            if (cs != null) cs.close();
            if (st != null) st.close();
            if (connection != null) connection.close();
            System.out.println("🔒 Connection closed successfully.");
        } catch (Exception e) {
            System.err.println("⚠️ Error closing connection: " + e.getMessage());
        }
    }
}
