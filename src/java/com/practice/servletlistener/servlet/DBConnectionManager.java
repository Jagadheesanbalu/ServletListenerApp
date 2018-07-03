/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.servletlistener.servlet;

import java.sql.Connection;

/**
 *
 * @author Jagadheesan Balu
 */
public class DBConnectionManager {
        
    private String dbURL;
	private String user;
	private String password;
	private Connection con;
	
	public DBConnectionManager(String url, String u, String p){
		this.dbURL=url;
		this.user=u;
		this.password=p;
		//create db connection now
                System.out.println("DB is connected.");
		
	}
	
	public Connection getConnection(){
		return this.con;
	}
	
	public void closeConnection(){
		//close DB connection here
            System.out.println("DB Connection closed.");
	}
}
