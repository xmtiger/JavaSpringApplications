/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaspringapplications.AOP.impl;

import javaspringapplications.AOP.CustomerBo;

/**
 *
 * @author MikeX
 */
public class CustomerBoImpl implements CustomerBo{

    @Override
    public void addCustomer() {
        System.out.println("addCustomer() is running");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String addCustomerReturnValue() {
        System.out.println("addCustomerReturnValue() is running");
        return "abc";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCustomerThrowException() throws Exception {
        System.out.println("addCustomerThrowException() is running");
        throw new Exception("Generic Error");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCustomerAround(String name) {
        System.out.println("addCustomerAround() is running, args : " + name);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
