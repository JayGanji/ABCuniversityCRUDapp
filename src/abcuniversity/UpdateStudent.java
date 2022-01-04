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
public class UpdateStudent {
        private Connection con ;
    private String path= "C:\\Users\\jayad\\Documents\\NetBeansProjects\\ABCuniversity\\ABCuniversity.accdb";  
    private String conString = "jdbc:ucanaccess://"+path;  
    private Statement aStatement;
    private ResultSet queryResults ;
    private ResultSetMetaData rsmd ;
    
    public void  showMenu(){
       
        String menuChoice="X";
        
        while (menuChoice.compareTo("Q")!=0){
            Scanner keyboard = new Scanner(System.in);
            // Print out 10 blank lines to make reading the menu easier
            for (int a=0;a<10;a++) {System.out.println();}

            // Diaplay the menu
            System.out.println("Update Menu");       
            System.out.println("---------------");     
            System.out.println("Q - Quit");       
            System.out.println("1 - Update First Name");
            System.out.println("2 - Update Last Name");
            menuChoice = keyboard.nextLine();     

            // Call the corresponding function based on their menu choice
            switch (menuChoice.toUpperCase()){
                case "1":
                    menuFunction1();
                    break;
                case "2":
                    menuFunction2();
                    break;
                case "Q":
                    return;
            }
        }
    }
    
    public void menuFunction1(){
        System.out.println("Update the student first name information below");
         String firstName ="";
         String sID = "";
         
         Scanner keyboard = new Scanner(System.in); 
         System.out.println("Enter the Student to update's ID");
         sID = keyboard.nextLine();
         
         
         
         System.out.println("Enter the first name");
          
         firstName = keyboard.nextLine();
         
         
         // Connect to the database         
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(conString);
        } catch(Exception sysEx){                    
            System.out.println("A broader system error occurred"+sysEx);             
        }
         
        try {
            
            // Core part of this method
            String sql = "update Student set FirstName='" + firstName + "' where ID=" + sID;
            
            // Execute the SQL statement
            con = DriverManager.getConnection(conString);
            aStatement = con.createStatement();
            aStatement.execute(sql);
            
            System.out.println("");
            System.out.println("Student#" + sID + " was successfully updated.");
         
        } catch(Exception dbEx){                    
            System.out.println("A Database error occured "+dbEx); 
        }  
    }

    

 public void menuFunction2(){
     System.out.println("Update student last name information below");
         
         String lastName ="";
         String sID = "";
         
         
         Scanner keyboard = new Scanner(System.in);  
         
         System.out.println("Enter the Student to update's ID");
         sID = keyboard.nextLine();
         
         System.out.println("Enter the last name");
         lastName = keyboard.nextLine();
         
         
         // Connect to the database         
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(conString);
        } catch(Exception sysEx){                    
            System.out.println("A broader system error occurred"+sysEx);             
        }
         
        try {
            
            // Core part of this method
            String sql = "update Student set LastName='" + lastName + "' where studentID=" + sID;
            
            // Execute the SQL statement
            con = DriverManager.getConnection(conString);
            aStatement = con.createStatement();
            aStatement.execute(sql);
            
            System.out.println("");
            System.out.println("Student#" + sID + " was successfully updated.");
         
        } catch(Exception dbEx){                    
            System.out.println("A Database error occured "+dbEx); 
        }  
    }

}
