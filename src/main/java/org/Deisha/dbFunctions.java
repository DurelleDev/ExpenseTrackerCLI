package org.Deisha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;

public class dbFunctions {

    public  Connection connectToDb(String dbName, String dbUser, String dbPassword){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+ dbName, dbUser, dbPassword);
            if(connection!=null)
                System.out.println("Connection established");
            else
                System.out.println("Connection unsuccessful");

        }
        catch (Exception e){
            System.out.println(e);
        }

        return connection;

    }

    public void createTable(Connection conn, String tableName){
        Statement statement;
        try{
            String query = "CREATE TABLE " + tableName+"(ID SERIAL PRIMARY KEY, data JSON);";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created");
        }
        catch(Exception e){
            System.out.println("createTable method FAILED!");
            System.out.println(e);
        }
    }

    public void addExpense(Connection conn, String json){
        Statement statement;

        try{
            String query = "INSERT INTO expenseJSON (data) VALUES (" + json +" ) ";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Insertion successful");
        }
        catch (Exception e){
            System.out.println("addExpense method FAILED!");
            System.out.println(e);
        }
    }

    public String findExpense(Connection conn, String expDesc){
        String expenseItem = "";
        Statement statement;

        try{
            String query = "SELECT id, data->> expenseDescription " +
                    "FROM expenseJSON " +
                    "WHERE (data->>'expenseDescription')";
            statement = conn.createStatement();
            expenseItem = String.valueOf(statement.executeQuery(query));
            System.out.println("findExpense Successful!");
        }
        catch (Exception e){
            System.out.println("findExpense FAILED!!!");
            System.out.println(e);
        }
        return expenseItem;
    }

}
