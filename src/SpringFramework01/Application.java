/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringFramework01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author MikeX
 */
@Configuration
@ComponentScan
public class Application {
    
    @Bean
    MessageService mockMessageService(){
        return new MessageService(){
            @Override
            public String getMessage(){
                return "Hello World!";
            }
        };
    }
    
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
    }
}
