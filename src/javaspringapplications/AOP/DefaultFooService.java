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
public class DefaultFooService implements FooService{

    @Override
    public Foo getFoo(String fooName, int age) {
        return new Foo(fooName, age);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
