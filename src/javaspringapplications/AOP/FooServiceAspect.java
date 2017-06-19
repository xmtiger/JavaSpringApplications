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
public class FooServiceAspect {
    public void beforeAdvice(){
        System.out.println("=====================before advice");
    }
    
    public void afterAdvice(){
        System.out.println("=====================after advice");
    }
}
