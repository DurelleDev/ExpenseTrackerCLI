package org.Deisha;

import java.util.Date;

public class Expense {
    private int expenseID;
    private Date expenseDate;
    private String expenseDesc;
    private double expenseAmt;

    public Expense(int expenseID, Date expenseDate, String expenseDesc, double expenseAmt){

        this.expenseID = expenseID;
        this.expenseDate = expenseDate;
        this.expenseDesc = expenseDesc;
        this.expenseAmt = expenseAmt;
    }

    public int getExpenseID(){
        return expenseID;
    }
    public Date getExpenseDate(){
        return expenseDate;
    }
    public String getExpenseDesc(){
        return expenseDesc;
    }
    public double getExpenseAmt(){
        return expenseAmt;
    }

   public void deleteExpense(String expID) {

   }

   public double totalExpense(){

        return 0.0;
   }

   public double totalExpenseMonth(){

        return 0.0;
   }

















}
