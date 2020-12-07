package com.management.springmvc.config;

import java.sql.Driver;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

@WebListener
public class MyContextListener implements ServletContextListener{

@Override
public void contextDestroyed(ServletContextEvent arg0) {
//System.out.println("App shutdown ...");

System.out.println("Deregistering SQL-Drivers from Listener...");
Enumeration<Driver> drivers = DriverManager.getDrivers();
while (drivers.hasMoreElements()) {
    Driver driver = drivers.nextElement();
    try {
        DriverManager.deregisterDriver(driver);
        System.out.println(driver.getClass().getName());
    } catch (SQLException e) {
        System.err.println("Error deregistering driver " +       
   driver.getClass().getName());
    }
    AbandonedConnectionCleanupThread.checkedShutdown();
 }
}

 @Override
 public void contextInitialized(ServletContextEvent arg0) {
 }
 }