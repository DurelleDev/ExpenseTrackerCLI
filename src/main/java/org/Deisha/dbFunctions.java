package org.Deisha;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbFunctions {

    public Connection connectToDb(String JDBC_DBNAME, String JDBC_USER, String JDBC_PASSWORD){
        Connection connection = null;

        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + JDBC_DBNAME, JDBC_USER, JDBC_PASSWORD);
            if (connection != null)
                System.out.println("Connection Successful!!!");
            else
                System.out.println("FAILED TO CONNECT TO DATABASE!!");
        }
        catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }







}
