package org.Deisha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class dbFunctions {
    private Connection conn = null;
    private String JDBC_NAME;
    private String JDBC_USER;
    private final String JDBC_PASSWORD;

    public dbFunctions(String JDBC_DBNAME, String JDBC_USER, String JDBC_PASSWORD){
        this.JDBC_NAME = JDBC_DBNAME;
        this.JDBC_USER = JDBC_USER;
        this.JDBC_PASSWORD = JDBC_PASSWORD;
    }

    public void connectToDb(){
        Connection connection = null;

        try{
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + JDBC_NAME, JDBC_USER, JDBC_PASSWORD);
            if (connection != null)
                System.out.println("Connection Successful!!!");
            else
                System.out.println("FAILED TO CONNECT TO DATABASE!!");
        }
        catch (Exception e){
            System.out.println(e);
        }
        this.conn = connection;
    }



    public void addExpense(String expenseDesc, double expenseAmt, String expenseDate){
        Statement statement;

        try{
            statement = conn.createStatement();
            String query = String.format("INSERT INTO expenses(expense_description, expense_amount, expense_date) VALUES ('%s',"+ expenseAmt +", '%s')", expenseDesc, expenseDate);
            statement.executeUpdate(query);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }





}
