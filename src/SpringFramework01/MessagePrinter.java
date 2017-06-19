/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpringFramework01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author MikeX
 */
@Component
public class MessagePrinter {
    final private MessageService service;
    
    @Autowired
    public MessagePrinter(MessageService service){
        this.service = service;
    }
    
    public void printMessage(){
        System.out.println(this.service.getMessage());
    }
}
