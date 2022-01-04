/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abcuniversity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;
/**
 *
 * @author jayad
 */
public class SelectTableMenu {
    
    public String  showMenu(){
       
        String menuChoice="X";
        
        while (menuChoice.compareTo("Q")!=0){
            Scanner keyboard = new Scanner(System.in);
            
            // Print out 10 blank lines in the output to make using the menus a bit more clear
            for (int a=0;a<10;a++) {System.out.println();}

            // Display the menu
            System.out.println("Select Table, or choose reports");       
            System.out.println("---------------");     
            System.out.println("Q - Quit");       
            System.out.println("1 - Students");
            System.out.println("2 - Majors Offered");
            System.out.println("3 - Degrees");  
            System.out.println("4 - Courses");
            System.out.println("5 - Classes");
            System.out.println("6 - Class Instances");
            System.out.println("7 - Reports");
            

            menuChoice = keyboard.nextLine();     

            // Based on which table they selected, return the name of the table to the caller for
            // Use in it's logic to determine which class to instantiate and execute
            switch (menuChoice.toUpperCase()){
                case "1":
                    return("STUDENTS");
                    
                case "2":
                    return("MAJORS OFFERED");

                case "3":
                    return("DEGREES");

                case "4":
                    return("COURSES");
                
                case "5":
                    return("CLASSES");

                case "6":
                    return("CLASS INSTANCES");

                case "7":
                    return("REPORTS");    
                    
                case "Q":
                    System.exit(0);
                   
            }
        }
    return("something odd happeded in the menu choices");
    }
}
