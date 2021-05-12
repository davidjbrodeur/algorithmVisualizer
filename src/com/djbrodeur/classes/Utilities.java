package com.djbrodeur.classes;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Utilities {

    public static int registerUserInput(MainMenu menu) {
        Scanner myObj = new Scanner(System.in);
        boolean choiceIsValid = false;
        int userInput = -1;

        while(!choiceIsValid){
            System.out.println("Enter a choice");
            try {
                String strInput = myObj.next();
                if(checkInputValidityForMenu(strInput, menu)){
                    userInput = convertInputStringIntoInt(strInput);
                    choiceIsValid = true;
                } else {
                    System.out.println("Invalid answer. Try again.");
                }
            } catch (Exception e){
                System.out.println(e);
            }
        }
        return userInput;
    }

    private static boolean checkInputValidityForMenu(String strInput, MainMenu menu) {
        if(!checkLength(strInput)) return false;
        if(!checkContent(strInput, menu)) return false;
        return true;
    }

    private static boolean checkContent(String strInput, MainMenu menu) {
        char charInput = strInput.charAt(0);
        int userInput = Character.getNumericValue(charInput);
        if(userInput > menu.MAX_OPTIONS){
            return false;
        } else {
            return true;
        }
    }

    private static boolean checkLength(String strInput) {
        if(strInput.length() != 1) return false;
        return true;
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static int convertInputStringIntoInt(String strInput) {
        char charInput = strInput.charAt(0);
        int userInput = Character.getNumericValue(charInput);
        return userInput;
    }

    public static void waitOneSecond() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e){
            // Pass
        }
    }

    public static void waitHalfSecond() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (Exception e){
            // Pass
        }
    }

    public static void showGraphic(Column[] valueArray) {
        String graphic = graphicStringBuilder(valueArray);
        System.out.println(graphic);
    }

    private static String graphicStringBuilder(Column[] valueArray) {
        String stringBuilt = "| ";
        for(Column c : valueArray){
            stringBuilt += c.getValue();
            stringBuilt += " | ";
        }
        return stringBuilt;
    }

    public static void swapElementOfArray(Column[] valueArray, int i, int j){
        Column temp = valueArray[i];
        valueArray[i] = valueArray[j];
        valueArray[j] = temp;
    }

}
