package com.example.aopdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy   // Enable Aspect Oriented Programming
@ComponentScan(basePackages="com.example")
public class AppConfig {

}
