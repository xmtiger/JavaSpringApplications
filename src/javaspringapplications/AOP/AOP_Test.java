/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaspringapplications.AOP;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author MikeX
 */
public class AOP_Test {
    public static void main(String[] args){
        int caseID = 1;
        switch(caseID){
            case 0:
                testSchemaBasedAOP();
                break;
            case 1:
                testAspectJBasedAOP();
                break;
            default:
                break;
        }
    }
    
    static void testSchemaBasedAOP(){
        System.out.println("==========testFooService()============");
        Path currentRelativePath = Paths.get("");
        String sPath = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + sPath);

        String xmlFilePath = sPath + "\\build\\classes\\javaspringapplications\\aop\\FooServiceAOP.xml";
        System.out.println("Current xml file path is: " + xmlFilePath);
        
        
        ApplicationContext ctx = new FileSystemXmlApplicationContext(xmlFilePath);
        Foo foo = ctx.getBean("foo", Foo.class);
        System.out.println(foo.getName());
    }
    
    static void testAspectJBasedAOP(){
        System.out.println("==========testAspect()============");
        Path currentRelativePath = Paths.get("");
        String sPath = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + sPath);

        String xmlFilePath = sPath + "\\build\\classes\\javaspringapplications\\aop\\Aspect_01.xml";
        System.out.println("Current xml file path is: " + xmlFilePath);
        
        
        ApplicationContext ctx = new FileSystemXmlApplicationContext(xmlFilePath);
        CustomerBo customer = ctx.getBean("customerBo", CustomerBo.class);
        customer.addCustomer();
        
        System.out.println();
        customer.addCustomerReturnValue();
        
        System.out.println();
        try {
            customer.addCustomerThrowException();            
            
        } catch (Exception ex) {
            System.out.println(ex);
            //Logger.getLogger(AOP_Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        customer.addCustomerAround("Hello China!");
    }
}
