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
public class UpdateClassInstance {
    private Connection con ;
    private String path= "C:\\Users\\jayad\\Documents\\NetBeansProjects\\ABCuniversity\\ABCuniversity.accdb";  
    private String conString = "jdbc:ucanaccess://"+path;  
    private Statement aStatement;
    private ResultSet queryResults ;
    private ResultSetMetaData rsmd ;
    
    public void  update(){
        System.out.println("Update class instance information below");
         String newGrade ="";
         String ciID = "";
        
         Scanner keyboard = new Scanner(System.in);  
         System.out.println("Enter the class instance ID for which to update");
         ciID = keyboard.nextLine();
         
         
         System.out.println("Enter the new Grade recieved (out of 100)");
         
         newGrade = keyboard.nextLine();
         
         
         
         // Connect to the database         
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con = DriverManager.getConnection(conString);
        } catch(Exception sysEx){                    
            System.out.println("A broader system error occurred"+sysEx);             
        }
         
        try {
            
            // Core part of this method
            String sql = "update Class_Instances set GradeReceived='" + newGrade + "' where ID=" + ciID;
            
            // Execute the SQL statement
            con = DriverManager.getConnection(conString);
            aStatement = con.createStatement();
            aStatement.execute(sql);
            
            System.out.println("");
            System.out.println("ClassInstance#" + ciID + " was successfully updated.");
         
        } catch(Exception dbEx){                    
            System.out.println("A Database error occured "+dbEx); 
        }  
    }
}
