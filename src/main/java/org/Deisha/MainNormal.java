package org.Deisha;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class MainNormal {
    public static void main(String [] args){
        String expenseDesc, expenseDate;
        double expenseAmt;

        dbFunctions db = new dbFunctions("expensedb", "postgres", "22952");
        db.connectToDb();

        Scanner userInput = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Whats the description of the expense?\n");
        expenseDesc = userInput.nextLine();
        System.out.println("Whats the Expense amount of "+expenseDesc+": \n");
        expenseAmt = userInput.nextDouble();
        expenseDate = String.valueOf(LocalDate.now());

        db.addExpense(expenseDesc,expenseAmt,expenseDate);

    }
}
