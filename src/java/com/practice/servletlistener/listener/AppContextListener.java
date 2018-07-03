/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.servletlistener.listener;

import com.practice.servletlistener.servlet.DBConnectionManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Jagadheesan Balu
 */
public class AppContextListener implements ServletContextListener {
    
    public void contextInitialized(ServletContextEvent eve){
        
        ServletContext ctx = eve.getServletContext();
        
        String url = ctx.getInitParameter("DBURL");
    	String u = ctx.getInitParameter("DBUSER");
    	String p = ctx.getInitParameter("DBPWD");
        
        DBConnectionManager dbmngr = new DBConnectionManager(url, u, p);
        
        ctx.setAttribute("DBMngr", dbmngr);
        System.out.println("Database connection initialized for Application.");
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        
        DBConnectionManager dbmngr = (DBConnectionManager) ctx.getAttribute("DBMngr");
        dbmngr.closeConnection();
        System.out.println("Database connection closed for Application.");
    }
    
    
}
