package com.example.aopdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.aopdemo.config.AppConfig;
import com.example.aopdemo.services.MyService;
import com.example.aopdemo.services.MyServiceB;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyService service = context.getBean(MyService.class);
        
        service.performTask();
        System.out.println(service.getData());
        
        try {
        	service.throwException();
        }
        catch (Exception e) {
        	System.out.println("Exception thrown "+e.getMessage());
        }
        
        MyServiceB serviceB = context.getBean(MyServiceB.class);
       
        serviceB.methodA();
        
        serviceB.methodB();
        
        ((AnnotationConfigApplicationContext)context).close();
        		
    }
}
