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
public class InsertCourses {
    private Connection con ;
    private String path= "C:\\Users\\jayad\\Documents\\NetBeansProjects\\ABCuniversity\\ABCuniversity.accdb";  
    private String conString = "jdbc:ucanaccess://"+path;  
    private Statement aStatement;
    private ResultSet queryResults ;
    private ResultSetMetaData rsmd ;
    
    public void  insert(){
        System.out.println("Enter the new course's information below");
         String courseName ="";
         String courseDesc ="";
         String courseCred ="";
   
         System.out.println("Enter the course name");
         Scanner keyboard = new Scanner(System.in);  
         courseName = keyboard.nextLine();
         System.out.println("Enter the course description");
         courseDesc = keyboard.nextLine();
         System.out.println("Enter the number of credits for the course");
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
            String sql = "insert into [Courses](CourseName, CourseDescription, NumberOfCredits) values ('" + courseName + "', '" + courseDesc + "', '" + courseCred + "')";
            
            // Execute the SQL statement
            con = DriverManager.getConnection(conString);
            aStatement = con.createStatement();
            aStatement.execute(sql);
            
            System.out.println("");
            System.out.println(courseName + " was successfully added.");
         
        } catch(Exception dbEx){                    
            System.out.println("A Database error occured "+dbEx); 
        }  
    }
}
