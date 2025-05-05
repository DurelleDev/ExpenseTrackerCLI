package org.Deisha.Json;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        dbFunctionsJson dbFunctionsJson = new dbFunctionsJson();
        dbFunctionsJson.connectToDb("expensedb", "postgres", "22952");

        int expenseID;
        LocalDate expenseDate;
        String expenseDescription;
        double expenseAmt = 0;
        int count = 0;

        Scanner userInput = new Scanner(System.in);

        //Getting user data for expenses
        System.out.println("Please enter a description: ");
        expenseDescription = userInput.next();

        try{
            System.out.println("Please enter the amount: ");
            expenseAmt = userInput.nextDouble();

        }catch (IllegalArgumentException e){
            System.out.println("Please enter a valid amount");
        }

        expenseDate = LocalDate.now();
        String expDate = expenseDate.toString();
        expenseID = count + 1;

    }

}
