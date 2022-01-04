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
public class Reports {
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
            System.out.println("Report Menu");       
            System.out.println("---------------");     
            System.out.println("Q - Quit");       
            System.out.println("1 - Total Enrollment for each semester throughout history");
            System.out.println("2 - A Given Student's GPA");
            System.out.println("3 - Building Usage for a Semester");
            menuChoice = keyboard.nextLine();     

            // Call the corresponding function based on their menu choice
            switch (menuChoice.toUpperCase()){
                case "1":
                    menuFunction1();
                    break;
                case "2":
                    menuFunction2();
                    break;
                case "3":
                    menuFunction3();
                    break;
                case "Q":
                    return;
            }
        }
    }
    
    public void menuFunction1(){
        System.out.println("Showing Total Enrollment for each semester throughout history");
        for (int a=0;a<4;a++) {System.out.println();}
         


        // Connect to the database         
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(conString);
        } catch(Exception sysEx){                    
            System.out.println("A broader system error occurred"+sysEx);             
        }
         
        try {
            
            // Core part of this method
            String sql = "select Semester,count(StudentID) from Classes inner join Class_Instances on Classes.ID=Class_Instances.ClassID group by Semester";
            
            // Execute the SQL statement
            con = DriverManager.getConnection(conString);
            aStatement = con.createStatement();
            queryResults = aStatement.executeQuery(sql);
            rsmd=queryResults.getMetaData();
         
        } catch(Exception dbEx){                    
            System.out.println("A Database error occured "+dbEx); 
        }    
        try {
            
            // Print out as many columns that you received from the SQL statement
            System.out.print(rsmd.getColumnCount());
            while (queryResults.next()){
               for (int a=1;a<=rsmd.getColumnCount();a++){
                   System.out.print(queryResults.getString(a) + " ");               
               }
               System.out.println("");
            }
        } catch (Exception e){
          
            System.out.print(e.getMessage());
    }
}
    

 public void menuFunction2(){
     
     String sid;
         System.out.println("Enter the ID of the student's GPA you want to see");
         Scanner keyboard = new Scanner(System.in);  
         sid = keyboard.nextLine();
         System.out.println("Showing GPA for student#" + sid);
         for (int a=0;a<4;a++) {System.out.println();}
         
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(conString);
        } catch(Exception sysEx){                    
            System.out.println("A broader system error occurred"+sysEx);             
        }
         
        try {
            String sql = "select StudentID,GradeReceived from [Class_Instances] where StudentID=" + sid;
            
            con = DriverManager.getConnection(conString);
            aStatement = con.createStatement();
            queryResults = aStatement.executeQuery(sql);
            rsmd=queryResults.getMetaData();
         
        } catch(Exception dbEx){                    
            System.out.println("A Database error occured "+dbEx); 
        }    
        try {
            
            // Step through each row in your results, then Print out as many columns that you received from the SQL statement
            while (queryResults.next()){
               for (int a=1;a<=rsmd.getColumnCount();a++){
                   System.out.print(queryResults.getString(a) + " ");               
               }
               System.out.println("");
                   }
            
        } catch (Exception e){
          
            System.out.print(e.getMessage());
    }

 }

 public void menuFunction3(){
         System.out.println("Showing building usages for a The Fall 2020 Semester");
         for (int a=0;a<4;a++) {System.out.println();}
         
         
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(conString);
        } catch(Exception sysEx){                    
            System.out.println("A broader system error occurred"+sysEx);             
        }
         
        try {
            String sql = "select Classes.Semester,Classes.ClassBuilding,count(Class_Instances.ID) from Classes inner join Class_Instances on Classes.ID=Class_Instances.ClassID group by ClassBuilding,Semester";
            
            con = DriverManager.getConnection(conString);
            aStatement = con.createStatement();
            queryResults = aStatement.executeQuery(sql);
            rsmd=queryResults.getMetaData();
         
        } catch(Exception dbEx){                    
            System.out.println("A Database error occured "+dbEx); 
        }    
        try {
            
            // Step through each row in your results, then Print out as many columns that you received from the SQL statement
            while (queryResults.next()){
               for (int a=1;a<=rsmd.getColumnCount();a++){
                   System.out.print(queryResults.getString(a) + " ");               
               }
               System.out.println("");
                   }
            
        } catch (Exception e){
          
            System.out.print(e.getMessage());
    }

    }

}
