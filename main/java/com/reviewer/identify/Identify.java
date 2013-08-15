package com.reviewer.identify;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jcraft.jsch.*;
import com.opensymphony.xwork2.ActionSupport;

public class Identify extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8322876765461057866L;
	
	
	static Logger logger = LogManager.getLogger(Identify.class.getName());
	
	private static final String HOST_KEY = "hostname";
	
	private static final String PORT_KEY = "port";
	
	private static String HOST_VALUE;
	
	private static int PORT_VALUE;
	
	private String USER;
	
	private String PASSWORD;

	@Override
	public String execute() {
		Properties settings = new Properties();
		
		logger.trace("Searching for settings.properties");
		try {
			settings.load(Identify.class.getClassLoader().getResourceAsStream("settings.properties"));
		} catch (IOException e) {
			logger.error("Failed to Load settings.properties - " + e.getMessage());
			return "cannot";
		}
		

		 
		
		Set<Object> keys = settings.keySet();
		
		for(Object k : keys) {
			if(null != k) {
				if(HOST_KEY.equals(k)) {
					HOST_VALUE = settings.getProperty(k.toString());
				}
				if(PORT_KEY.equals(k)) {
					PORT_VALUE = Integer.parseInt(settings.getProperty(k.toString()));
				}
			}
		}
		
		logger.trace("Connection Parameters - " + HOST_VALUE + " " + PORT_VALUE);
		logger.trace("Session Parameters - " + USER + " " + PASSWORD);
		
		
		JSch shell = new JSch();
		
		try {
			Session session = shell.getSession(USER, HOST_VALUE, PORT_VALUE);
			
			java.util.Properties config = new java.util.Properties(); 
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			
			session.setPassword(PASSWORD);
			logger.trace("Before Connecting!");
			session.connect();
			logger.trace("Connection Successful!");
			
		} catch (JSchException e) {
			logger.error("Failed to Login - " + e.getMessage());
			return "cannot";
		}
		
		
		return "identified";
	}
	
	public String getUser() {
		return USER;
	}

	public void setUser(String user) {
		USER = user;
	}

	public String getPwd() {
		return PASSWORD;
	}

	public void setPwd(String pwd) {
		PASSWORD = pwd;
	}

}
