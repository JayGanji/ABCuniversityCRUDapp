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
public class ActionMenu {
    
    public String  showMenu(){
        String menuChoice;
        Scanner keyboard = new Scanner(System.in);
        
        // Print space between last output and the new menu.
        for (int a=0;a<10;a++) {System.out.println();}
        
       
        System.out.println("Action Menu");       
        System.out.println("---------------");       
        
        System.out.println("Q - Quit");       
        System.out.println("1 - Show Data");
        System.out.println("2 - Insert Data");       
        System.out.println("3 - Update data");
        System.out.println("4 - Delete Data");
        menuChoice = keyboard.nextLine();     
        
        return menuChoice;
        
    }
    
}
