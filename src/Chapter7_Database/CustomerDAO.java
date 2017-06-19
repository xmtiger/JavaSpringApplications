/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chapter7_Database;

/**
 *
 * @author MikeX
 */
public interface CustomerDAO {
    public void insert(Customer customer);
    public Customer findByCustomerId(int custId);
    public boolean createTable(String tableName);
}
