package abcuniversity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author jayad
 */
public class ABCuniversity {
private static  String currentTable="";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        try {
//            
//            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//             String path= "C:\\Users\\jayad\\Documents\\NetBeansProjects\\ABCuniversity\\ABCuniversity.accdb";  
//            String conString = "jdbc:ucanaccess://"+path;  
//            Connection con = DriverManager.getConnection(conString);
//            
//            try {                     
//                Statement aStatement = con.createStatement();
//                ResultSet queryResults = aStatement.executeQuery("SELECT * FROM Student");
//                int rowCount = 0;
//                while(queryResults.next() && rowCount<10){
//                    System.out.print(Integer.toString(rowCount)+"\t"); 
//                    System.out.print(queryResults.getString(1));       
//                    System.out.println(" "+queryResults.getString(2));
//                    rowCount++;
//                } 
//            } catch(Exception dbEx){                    
//                System.out.println("A Database error occured "+dbEx); 
//            }    
//        } catch(Exception sysEx){                    
//            System.out.println("A broader system error occurred"+sysEx);             
//        }

        // Run the select table menu followed by the select action menu
        SelectTableMenu selTable = new SelectTableMenu();
        ActionMenu mainMen= new ActionMenu();

        while(true){
            currentTable = selTable.showMenu();
            String menuChoice;
            
            
            if (currentTable.toUpperCase()=="Q") System.exit(1);
            // Instantiate the correct class based on which Table and Action the user selected.
            // Note the nested switch statement, one for table and one for actions within that table
            switch (currentTable.toUpperCase()){
                case "STUDENTS" :
                    menuChoice = mainMen.showMenu();
                    switch (menuChoice.toUpperCase()){
                        case "1":
                            ShowStudents sS = new ShowStudents();
                            sS.showMenu();
                            break;
                        case "2":
                            InsertStudents iS = new InsertStudents();
                            iS.insert();
                            break;
                        case "3":   
                            UpdateStudent uS = new UpdateStudent();
                            uS.showMenu();
                            break;
                        case "4":    
                            DeleteStudent dS = new DeleteStudent();
                            dS.delete();
                            break;
                    }
                    break;     
                case "MAJORS OFFERED":
                    menuChoice = mainMen.showMenu();
                    switch (menuChoice.toUpperCase()){
                        case "1":
                            ShowMajors sM = new ShowMajors();
                            sM.showMenu();
                            break;
                        case "2":
                            InsertMajors iM = new InsertMajors();
                            iM.insert();
                            break;
                        case "3":     
                            UpdateMajor uM = new UpdateMajor();
                            uM.update();
                            break;
                        case "4":     
                            DeleteMajor dM = new DeleteMajor();
                            dM.delete();
                            break;
                    }
                    break;
                case "DEGREES":
                    menuChoice = mainMen.showMenu();
                    switch (menuChoice.toUpperCase()){
                        case "1":
                            ShowDegrees sD = new ShowDegrees();
                            sD.showMenu();
                            break;
                        case "2":
                            InsertDegrees iD = new InsertDegrees();
                            iD.insert();
                            break;
                        case "3":     
                            UpdateDegree uD = new UpdateDegree();
                            uD.update();
                            break;
                        case "4":     
                            DeleteDegree dD = new DeleteDegree();
                            dD.delete();
                            break;    
                    }
                    break;
                    
                case "COURSES":
                    menuChoice = mainMen.showMenu();
                    switch (menuChoice.toUpperCase()){
                        case "1":
                            ShowCourses sCo = new ShowCourses();
                            sCo.showMenu();
                            break;
                        case "2":
                            InsertCourses iCo = new InsertCourses();
                            iCo.insert();
                            break;
                        case "3":     
                            UpdateCourse uCo = new UpdateCourse();
                            uCo.showMenu();
                            break;
                        case "4":     
                            DeleteCourse dCo = new DeleteCourse();
                            dCo.delete();
                            break;    
                    }
                      break;
                case "CLASSES":
                    menuChoice = mainMen.showMenu();
                    switch (menuChoice.toUpperCase()){
                        case "1":
                            ShowClasses sCl = new ShowClasses();
                            sCl.showMenu();
                            break;
                        case "2":
                            InsertClasses iCl = new InsertClasses();
                            iCl.insert();
                            break;
                        case "3":     
                            UpdateClass uCl = new UpdateClass();
                            uCl.update();
                            break;
                        case "4":  
                            DeleteClass dCl = new DeleteClass();
                            dCl.delete();
                            break;    
                    }
                    break;
                case "CLASS INSTANCES":
                    menuChoice = mainMen.showMenu();
                    switch (menuChoice.toUpperCase()){
                        case "1":
                            ShowClassInstances sCI = new ShowClassInstances();
                            sCI.showMenu();
                            break;
                        case "2":
                            InsertClassInstances iCI = new InsertClassInstances();
                            iCI.insert();
                            break;
                        case "3":     
                            UpdateClassInstance uCI = new UpdateClassInstance();
                            uCI.update();
                            break;
                        case "4":     
                            DeleteClassInstance dCI = new DeleteClassInstance();
                            dCI.delete();
                            break;    
                    }
                    break;
                case "REPORTS":
                    Reports report = new Reports();
                    report.showMenu();
                    break;
            }

        }
    }
    
}
