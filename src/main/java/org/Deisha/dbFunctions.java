package org.Deisha;

import java.sql.*;
import java.time.LocalDate;

public class dbFunctions {
    private Connection conn = null;
    private String JDBC_NAME;
    private String JDBC_USER;

    protected dbFunctions(String JDBC_DBNAME, String JDBC_USER){
        this.JDBC_NAME = JDBC_DBNAME;
        this.JDBC_USER = JDBC_USER;
    }

    protected void connectToDb(){
        Connection connection = null;

        try{
            String JDBC_PASSWORD = "";
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

    protected void displayExpenses(){
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

    protected void displaySummary(){
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

            System.out.println(String.format("Total expenses: R%.2f",expenses));

        }catch (SQLException e){
            System.out.println(e);
        }
    }

    protected void displaySpecificMonth(int month){
        Statement statement;
        LocalDate date = LocalDate.now();
        int iYear = LocalDate.now().getYear();
        int iMonth = Integer.parseInt(date.toString().substring(5, 7));
        double expenses = 0;
        ResultSet results;

        try{
            statement = conn.createStatement();
            String query = String.format("Select * from expenses where expense_date = %d-%02d-", iYear, iMonth);
            results = statement.executeQuery(query);
            System.out.println("Success!");

            while(results.next()){
                expenses += results.getDouble("expense_amount");
            }

        }
        catch (Exception e){
            System.out.println("Failed! (displaySpecificMonth)");
            System.out.println(e);
        }
    }

    protected void addExpense(String expenseDesc, double expenseAmt, String expenseDate){
        Statement statement;

        try{
            statement = conn.createStatement();
            String query = String.format("INSERT INTO expenses(expense_description, expense_amount, expense_date) VALUES ('%s',"+ expenseAmt +", '%s')", expenseDesc, expenseDate);
            statement.executeUpdate(query);
            System.out.println(String.format("added the expense: %s ",expenseDesc));
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    protected void deleteExpense(String expDesc){
        Statement statement;

        try{
            statement = conn.createStatement();
            String query = String.format("DELETE FROM expenses WHERE expense_description = '%s'", expDesc);
            statement.executeUpdate(query);
            System.out.println(String.format("Successfully deleted: %s", expDesc));
        }
        catch (SQLException e)
        {
            System.out.println("FAILED (deleteExpense");
            System.out.println(e);
        }
    }

}
