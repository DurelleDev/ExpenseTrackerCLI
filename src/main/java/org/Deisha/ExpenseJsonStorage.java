package org.Deisha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExpenseJsonStorage {

    //JDBC, URL, USER, PASSWORD

    private static final String JDBC_URL ="jdbc.postgresql://localhost:5432/Expenses";
    private static final String USER = "postgres";
    private static final String PASSWORD = "22952";

    public static Connection getConnection() throws SQLException{
        try{
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        }
        catch (ClassNotFoundException e){
            throw new SQLException("PostgreSQL JDBC driver not found");
        }
    }

    public static void storeJson(String jsonString){
        try{
            PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO expenses_table (data) VALUES (?)");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


    }



}
