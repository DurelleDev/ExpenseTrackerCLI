package org.Deisha;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class Expense {
    private int expenseID;
    private LocalDate expenseDate;
    private String expenseDesc;
    private double expenseAmt;

    public Expense(int expenseID, LocalDate expenseDate, String expenseDesc, double expenseAmt){

        this.expenseID = expenseID;
        this.expenseDate = expenseDate;
        this.expenseDesc = expenseDesc;
        this.expenseAmt = expenseAmt;
    }

    public int getExpenseID(){
        return expenseID;
    }
    public LocalDate getExpenseDate(){
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
