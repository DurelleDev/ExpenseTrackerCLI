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

        int expenseID;
        LocalDate expenseDate;
        String expenseDesc;
        double expenseAmt = 0;
        int count = 0;

        System.out.println();

        Scanner userInput = new Scanner(System.in);
        //HashMap<String, Object> expenseData = new HashMap<>();

        //Getting user data for expenses
        System.out.println("Please enter a description: ");
        expenseDesc = userInput.next();

        try{
            System.out.println("Please enter the amount: ");
            expenseAmt = userInput.nextDouble();

        }catch (IllegalArgumentException e){
            System.out.println("Please enter a valid amount");
        }

        expenseDate = LocalDate.now();
        String expDate = expenseDate.toString();
        expenseID = count + 1;

        //hash to store data in JSON
//        expenseData.put("expenseID", expenseID);
//        expenseData.put("expenseDate", expenseDate);
//        expenseData.put("expenseDescription", expenseDesc);
//        expenseData.put("expenseAmount", expenseAmt);


        //ObjectMapper (Used to convert data between Java objects and JSON)
        ObjectMapper objectMapper = new ObjectMapper(); // create
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); //Enable pretty printing

       try
       {
           //Expense(int expenseID, Instant expenseDate, String expenseDesc, double expenseAmt
            String jsonString = objectMapper.writeValueAsString(new Expense(expenseID, expDate, expenseDesc, expenseAmt));
            ExpenseJsonStorage.storeJson(jsonString);

       }
       catch (JsonProcessingException e){
           //e.printStackTrace();
           System.out.println(e);
        }


        // File file = new File("expense_data_jackson.json");

//        try{
//            objectMapper.writeValue(file, userInput);
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
    }

}
