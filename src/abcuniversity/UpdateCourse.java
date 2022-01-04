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
public class UpdateCourse {
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
            System.out.println("1 - Update Course Description");
            System.out.println("2 - Update Course Credits");
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
        System.out.println("Update the course information below");
         String courseDesc ="";
         String cID = "";
         
         Scanner keyboard = new Scanner(System.in); 
         System.out.println("Enter the course to update's ID");
         cID = keyboard.nextLine();
         
         
         
         System.out.println("Enter the new course description");
          
         courseDesc = keyboard.nextLine();
         
         
         // Connect to the database         
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(conString);
        } catch(Exception sysEx){                    
            System.out.println("A broader system error occurred"+sysEx);             
        }
         
        try {
            
            // Core part of this method
            String sql = "update Courses set CourseDescription='" + courseDesc + "' where ID=" + cID;
            
            // Execute the SQL statement
            con = DriverManager.getConnection(conString);
            aStatement = con.createStatement();
            aStatement.execute(sql);
            
            System.out.println("");
            System.out.println("Course#" + cID + " was successfully updated.");
         
        } catch(Exception dbEx){                    
            System.out.println("A Database error occured "+dbEx); 
        }  
    }

    

 public void menuFunction2(){
     System.out.println("Update course information below");
         
         String courseCred ="";
         String cID = "";
         
         
         Scanner keyboard = new Scanner(System.in);  
         
         System.out.println("Enter the course to update's ID");
         cID = keyboard.nextLine();
         
         System.out.println("Enter the course's new number of credits");
         courseCred = keyboard.nextLine();
         
         
         // Connect to the database         
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(conString);
        } catch(Exception sysEx){                    
            System.out.println("A broader system error occurred"+sysEx);             
        }
         
        try {
            
            // Core part of this method
            String sql = "update Courses set NumberOfCredits='" + courseCred + "' where courseID=" + cID;
            
            // Execute the SQL statement
            con = DriverManager.getConnection(conString);
            aStatement = con.createStatement();
            aStatement.execute(sql);
            
            System.out.println("");
            System.out.println("Course#" + cID + " was successfully updated.");
         
        } catch(Exception dbEx){                    
            System.out.println("A Database error occured "+dbEx); 
        }  
    }

}
