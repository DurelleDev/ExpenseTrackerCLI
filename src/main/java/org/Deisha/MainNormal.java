package org.Deisha;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class MainNormal {
    public static void main(String [] args){
        String expenseDesc, expenseDate, deleteExp;
        char userChoice;
        double expenseAmt;

        dbFunctions db = new dbFunctions("expensedb", "postgres");
        db.connectToDb();

        Scanner userInput = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("======================\n" +
                "What do you want to do?\n" +
                "=======================\n" +
                "A. Display the Expenses?\n" +
                "B. Add an expense?\n" +
                "C. Delete an expense?\n" +
                "D. Summary of the expenses\n" +
                "E. Summary for a specific month || Have to change type in database");

        userChoice = Character.toUpperCase(userInput.nextLine().charAt(0));
        switch(userChoice) {
            case 'A':
                db.displayExpenses();
                break;

            case 'B':
                System.out.println("Whats the description of the expense?\n");
                expenseDesc = userInput.nextLine();
                System.out.println("Whats the Expense amount of "+expenseDesc+": \n");
                expenseAmt = userInput.nextDouble();
                expenseDate = String.valueOf(LocalDate.now());
                db.addExpense(expenseDesc,expenseAmt,expenseDate);
                break;

            case 'C':
                System.out.println("What expense do you want to delete? ");
                deleteExp = userInput.nextLine();
                db.deleteExpense(deleteExp);
                break;
            case 'D':
                    db.displaySummary();
                break;
            case 'E':
                System.out.println("What month do you want to display?");
                db.displaySpecificMonth(userInput.nextInt());
                break;

            default:
                System.out.println("Invalid choice");
        }



//        System.out.println("Whats the description of the expense?\n");
//        expenseDesc = userInput.nextLine();
//        System.out.println("Whats the Expense amount of "+expenseDesc+": \n");
//        expenseAmt = userInput.nextDouble();
//        expenseDate = String.valueOf(LocalDate.now());
//        db.addExpense(expenseDesc,expenseAmt,expenseDate);

    }
}
