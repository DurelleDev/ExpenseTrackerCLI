package org.Deisha;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        int expenseID;
        LocalDate expenseDate;
        String expenseDesc;
        double expenseAmt;

        System.out.println();

        Scanner userInput = new Scanner(System.in);
        HashMap<String, Object> expenseData = new HashMap<>();

        //Getting user data for expenses

        try{
            System.out.println("Please enter a description: ");
            expenseDesc = userInput.next();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        //hash to store data in JSON
        expenseData.put("expenseID", 453467);
        expenseData.put("expenseDate", LocalDate.now());
        expenseData.put("expenseDescription", "Breakfast");
        expenseData.put("expenseAmount", 4500);


        //ObjectMapper (Used to convert data between Java objects and JSON)
        ObjectMapper objectMapper = new ObjectMapper(); // create
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); //Enable pretty printing

        File file = new File("expense_data_jackson.json");

        try{
            objectMapper.writeValue(file, userInput);
        }
        catch (IOException e){
            e.printStackTrace();
        }




    }
}