package org.Deisha;

import java.sql.*;

public class dbFunctions {
    private Connection conn = null;
    private String JDBC_NAME;
    private String JDBC_USER;

    public dbFunctions(String JDBC_DBNAME, String JDBC_USER){
        this.JDBC_NAME = JDBC_DBNAME;
        this.JDBC_USER = JDBC_USER;
    }

    public void connectToDb(){
        Connection connection = null;

        try{
            String JDBC_PASSWORD = "22952";
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

    public void displayExpenses(){
        Statement statement;
        ResultSet displayResult;
        try{
            statement = conn.createStatement();
            String query = "SELECT * FROM expenses";
            displayResult = statement.executeQuery(query);
            System.out.println("Sucess!!\n");

            while(displayResult.next()){
                System.out.print(displayResult.getString("expense_id") + " ");
                System.out.print(displayResult.getString("expense_description") + " ");
                System.out.print(displayResult.getString("expense_amount") + " ");
                System.out.println(displayResult.getString("expense_date"));
            }
        }
        catch (SQLException e){
            System.out.println("FAILED! (displayExpense)");
            System.out.println(e);
        }
    }

    public void displaySummary(){
        Statement statement;
        ResultSet results;
        double expenses = 0;

        try{
            statement = conn.createStatement();
            String query = String.format("SELECT * FROM expenses");
            results = statement.executeQuery(query);

            while(results.next()){
                expenses += results.getDouble("expense_amount");
            }

            System.out.println("Total expenses: R"+expenses);

        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void addExpense(String expenseDesc, double expenseAmt, String expenseDate){
        Statement statement;

        try{
            statement = conn.createStatement();
            String query = String.format("INSERT INTO expenses(expense_description, expense_amount, expense_date) VALUES ('%s',"+ expenseAmt +", '%s')", expenseDesc, expenseDate);
            statement.executeUpdate(query);
            System.out.println("added the expense: "+expenseDesc);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteExpense(String expDesc){
        Statement statement;

        try{
            statement = conn.createStatement();
            String query = String.format("DELETE FROM expenses WHERE expense_description = '%s'", expDesc);
            statement.executeUpdate(query);
            System.out.println("Successfully deleted: "+ expDesc);
        }
        catch (SQLException e)
        {
            System.out.println("FAILED (deleteExpense");
            System.out.println(e);
        }
    }





}
