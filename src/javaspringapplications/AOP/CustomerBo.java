/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaspringapplications.AOP;

/**
 *
 * @author MikeX
 */
public interface CustomerBo {
    void addCustomer();
    
    String addCustomerReturnValue();
    
    void addCustomerThrowException() throws Exception;
    
    void addCustomerAround(String name);
}
