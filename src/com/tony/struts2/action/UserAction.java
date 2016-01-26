package com.tony.struts2.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

public class UserAction implements SessionAware, ApplicationAware {

	
	private String username;
	
	public void setUsername(String username){
		
		this.username = username;
		
	}
	
	
	public String execute(){
		
		
		//Store user information in Session
		//1. Gain session. by achieving SessionAware interface
		
		
		//2. Gain login information by adding setter() method in the Action
		
		
		//3. Put user information in Session
		session.put("username", username);
		
		//online number + 1
		//1. Gain current online clients number from Application
		Integer count = (Integer) application.get("count");
		if(count == null){
			count = 0;
			
		}
		//2. Add one on the current clients number
		count++;
		
		application.put("count", count);
		
		
		return "login-success";
	}

	/**
	 * 
	 */
	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
		
	}

	private Map<String, Object> application;
	
	@Override
	public void setApplication(Map<String, Object> arg0) {
		this.application = arg0;
		
		
	}

	public String logout(){
		
		//1. Online client number -1: Gain the number of online client, if it > 0, then -1
		Integer count = (Integer)application.get("count");
		
		if(count != null && count > 0){
			count--;
			application.put("count", count);
		}
		
		//2. Session invalide
		((SessionMap)session).invalidate();
		
		
		return "logout-success";
	}
	
}

