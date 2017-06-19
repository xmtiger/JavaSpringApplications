/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter7_Database;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;



/**
 *
 * @author MikeX
 */
public class JdbcTemplateTest {
    
    private static JdbcTemplate jdbcTemplate;
    
    @Test
    public static void test(){
        int caseId = 1;
        switch(caseId){
            case 0:
                test_mySQL();
                break;
            case 1:
                test_Derby();
                break;
            case 2:
                test_mem_derby();
                break;
            default:
                break;
        }
    }
    
    //-------------------------------------------------
    @Test
    public static void test_mySQL(){
        System.out.println("==========JdbcTempateTest()============");
        Path currentRelativePath = Paths.get("");
        String sPath = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + sPath);

        String xmlFilePath = sPath + "\\build\\classes\\Chapter7_Database\\Spring_Module.xml";
        System.out.println("Current xml file path is: " + xmlFilePath);
        
        
        ApplicationContext ctx = new FileSystemXmlApplicationContext(xmlFilePath);
        CustomerDAO customerDAO = ctx.getBean("customerDAO", CustomerDAO.class);
        //Customer customer = new Customer(1, "John", 28);
        //customerDAO.insert(customer);
        
        Customer customer1 = customerDAO.findByCustomerId(1);
        System.out.println("customer name: " + customer1.getName() + ", customer age: " + customer1.age);
    }
    
    @Test
    public static void test_Derby(){
        System.out.println("==========JdbcTempateTest()============");
        Path currentRelativePath = Paths.get("");
        String sPath = currentRelativePath.toAbsolutePath().toString();
        System.out.println("Current relative path is: " + sPath);

        String xmlFilePath = sPath + "\\build\\classes\\Chapter7_Database\\Spring_Module.xml";
        System.out.println("Current xml file path is: " + xmlFilePath);
        
        
        ApplicationContext ctx = new FileSystemXmlApplicationContext(xmlFilePath);
        CustomerDAO customerDAO = ctx.getBean("customerDAO_Derby", CustomerDAO.class);
        
        boolean bCreateTable = customerDAO.createTable("Customer");
        if(bCreateTable == false)
            return;
        
        customerDAO.insert(new Customer(1, "Tom", 22));
        
        Customer customer = new Customer(2, "John", 29);
        customerDAO.insert(customer);
        
        Customer customer1 = customerDAO.findByCustomerId(1);
        if(customer1 != null)
            System.out.println("customer name: " + customer1.getName() + ", customer age: " + customer1.age);
    }
    
    public static void test_mem_derby(){
        String driver = "jdbc:derby:memory:myDB; create=true";
        try {
            Connection conn = DriverManager.getConnection(driver);
            
            if(conn == null)
                System.out.println("failure in derby memory database created");
            
            Statement st1 = conn.createStatement();
            st1.execute("Create table users (id int primary key, name varchar(30))");
            
            st1.executeUpdate("insert into users values (1, 'tom')");
            
            conn.commit();
            
            ResultSet rs = st1.executeQuery("Select * from users");
            while(rs.next()){
                System.out.println( rs.getInt("id") + ": " + rs.getString("name"));
            }
            st1.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(JdbcTemplateTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
