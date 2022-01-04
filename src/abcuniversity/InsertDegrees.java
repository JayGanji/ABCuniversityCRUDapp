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
public class InsertDegrees {
    private Connection con ;
    private String path= "C:\\Users\\jayad\\Documents\\NetBeansProjects\\ABCuniversity\\ABCuniversity.accdb";  
    private String conString = "jdbc:ucanaccess://"+path;  
    private Statement aStatement;
    private ResultSet queryResults ;
    private ResultSetMetaData rsmd ;
    
    public void  insert(){
        System.out.println("Enter the new degree's information below");
         String degreeName ="";
        
         System.out.println("Enter the degree name");
         Scanner keyboard = new Scanner(System.in);  
         degreeName = keyboard.nextLine();
         
         
         // Connect to the database         
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(conString);
        } catch(Exception sysEx){                    
            System.out.println("A broader system error occurred"+sysEx);             
        }
         
        try {
            
            // Core part of this method
            String sql = "insert into [Degrees](DegreeName) values ('" + degreeName +"')";
            
            // Execute the SQL statement
            con = DriverManager.getConnection(conString);
            aStatement = con.createStatement();
            aStatement.execute(sql);
            
            System.out.println("");
            System.out.println(degreeName + " was successfully added.");
         
        } catch(Exception dbEx){                    
            System.out.println("A Database error occured "+dbEx); 
        }  
    }
}
