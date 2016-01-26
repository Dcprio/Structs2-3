package com.tony.struts2.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class TestServletActionContextAction {

	public String execute(){
		
		/**
		 * ServletActionContext: Can take all Servlet API object for the current Action Object
		 * How:
		 * 1. Gain HttpServeltRequest: ServletActionContext.getRequest();
		 * 2. Gain HttpSession: ServletActionContext.getRequest().getSession();
		 * 3. Gain ServletContext: ServletContext.getServletContext();
		 * 
		 * 
		 */
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		ServletContext servletContext = ServletActionContext.getServletContext();
				
		System.out.println("execute....");
		
		return "success";
	}
	
	
}
