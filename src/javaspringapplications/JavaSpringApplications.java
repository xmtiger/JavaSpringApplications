/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaspringapplications;

import Chapter7_Database.Chapter7_Database_Test;
import SpringFramework01.Application;
import javaspringapplications.AOP.AOP_Test;

/**
 *
 * @author MikeX
 */
public class JavaSpringApplications {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int caseID = 1;
        switch(caseID){
            case 0:
                AOP_Test.main(args);
                break;
            case 1:
                Chapter7_Database_Test.main(args);
                break;
            case 2:
                Application.main(args);
                break;
            default:
                break;
        }
    }    
}
