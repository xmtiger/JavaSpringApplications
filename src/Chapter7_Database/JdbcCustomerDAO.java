/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter7_Database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author MikeX
 */
public class JdbcCustomerDAO implements CustomerDAO{
    private DataSource dataSource;
    
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        setJdbcTemplate(dataSource);
    }
    
    public void setJdbcTemplate(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public void insert(Customer customer){
               
        int custId = customer.getCustomerId();
        if(this.findByCustomerId(custId) != null){
            System.out.println("the customer is alread in the database, and can not be duplicated");
            return;
        }
        
        String sql = "INSERT INTO CUSTOMER " + "(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
        Connection conn = null;
        try{
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, customer.getCustomerId());
            ps.setString(2, customer.getName());
            ps.setInt(3, customer.getAge());
            ps.execute();
            ps.close();
            conn.commit();
            
            Customer t1 = this.findByCustomerId(custId);
            if(t1 != null)
                System.out.println("insert sucessfully");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if( conn != null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public Customer findByCustomerId(int customerId){
        String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
        Connection conn = null;
        try{
            if(dataSource == null){
                System.out.println("Connection from DataSource is failed");
                return null;
            }
            conn = dataSource.getConnection();
            if(conn == null){
                System.out.println("Connection from DataSource is failed");
                return null;
            }
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, customerId);
            Customer customer = null;
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                customer = new Customer(
                        rs.getInt("CUST_ID"), 
                        rs.getString("NAME"), 
                        rs.getInt("Age"));
            }
            rs.close();
            ps.close();
            return customer;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if( conn != null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    
    //create table
    @Override
    public boolean createTable(String tableName){
        String creatTableSql = "create table " + tableName + "(CUST_ID int PRIMARY KEY, "
                + "name varchar(30), age int)";
        
        if(jdbcTemplate == null){
            System.out.println("jdbcTemplate is null");
            return false;
        }            
        
        jdbcTemplate.update(creatTableSql);
        
        return true;
    }
}
