package org.Deisha;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        dbFunctions dbFunctions = new dbFunctions();
        dbFunctions.connectToDb("expensedb", "postgres", "22952");

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
