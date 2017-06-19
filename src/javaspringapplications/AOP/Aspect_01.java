/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaspringapplications.AOP;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author MikeX
 */
@Aspect()
public class Aspect_01 {
    @Pointcut("execution(* javaspringapplications.AOP.CustomerBo.addCustomer(..))")
    private void pointCutName01() {} //the pointcut signature
    
    @Before("execution(* javaspringapplications.AOP.CustomerBo.addCustomer(..))")
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("beforeAdvice() is running!");
        System.out.println("hijacked: " + joinPoint.getSignature().getName());
        System.out.println("***************");
    }
    //-------------------------------------------------------------------------------------------------
    @After("pointCutName01()")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("***************");
        System.out.println("afterAdvice() is running!");
        System.out.println("hijacked: " + joinPoint.getSignature().getName());        
    }
    
    //------------------------------------------------------------------------------------------------------------
    @AfterReturning(pointcut = "execution(* javaspringapplications.AOP.CustomerBo.addCustomerReturnValue(..))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        
        System.out.println("afterReturning() is running");
        System.out.println("hijacked: " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is: " + result);
        System.out.println("***************");
    }
    
    //--------------------------------------------------------------------------------------------------------------
    @AfterThrowing(pointcut = "execution(* javaspringapplications.AOP.CustomerBo.addCustomerThrowException(..))",
            throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error){
        System.out.println("afterThrowing() is running");
        System.out.println("hijacked " + joinPoint.getSignature().getName());
        System.out.println("Exception: " + error);
        System.out.println("************");
    }
    
    //---------------------------------------------------------------------------------------------------------------
    @Around("execution(* javaspringapplications.AOP.CustomerBo.addCustomerAround(..))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println();
        System.out.println("aroundAdvice() is running!");
        System.out.println("hijacked method: " + joinPoint.getSignature().getName());
        System.out.println("hijacked arguments: " + Arrays.toString(joinPoint.getArgs()));
        
        System.out.println("Around before is running!");
        joinPoint.proceed();    //continue on the intercepted method
        System.out.println("Aroudn after is running!");
        System.out.println();
    }
}
