/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.servletlistener.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jagadheesan Balu
 */
public class MyServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        
        ServletContext cxt  = req.getServletContext();
        
        // Context Add & Remove Attribute
        cxt.setAttribute("user", "Jaggy");
        String userName = (String) cxt.getAttribute("user");
        System.out.println("userName :"+userName);
        cxt.removeAttribute("user");
        
        // Session invalidate
        HttpSession session = req.getSession();
        if( null != session )
            session.invalidate();
        
        PrintWriter out = res.getWriter();
        out.print("HI User :"+userName);
        
        
    }
    
}
