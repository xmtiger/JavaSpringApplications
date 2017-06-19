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
public class Customer {
    int customerId;
    String name;
    int age;
    
    public Customer(int custId, String name, int age){
        this.customerId = custId;
        this.name = name;
        this.age = age;
    }
    
    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
