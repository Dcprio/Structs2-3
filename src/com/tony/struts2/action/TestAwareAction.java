package com.tony.struts2.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class TestAwareAction implements ApplicationAware, SessionAware, ParameterAware, RequestAware {
	
	public String execute(){
		
		//1. Add an attribute in application: applicationKey2 - applicationValue2
		application.put("applicationKey2", "applicationValue2");
		request.put("requestKey2", "requestValue2");
		session.put("sessionKey2", "sessionValue2");
		
		
		//2. Read and print an attribute(date) from application
		System.out.println(application.get("date"));
		
		
		
		
		return "success";
		
		
	}

	private Map<String, Object> application;
	private Map<String, Object> request;
	private Map<String, String[]> parameters;
	private Map<String, Object> session;
	
	
	@Override
	public void setApplication(Map<String, Object> arg0) {
		
		this.application = arg0;
	
	
	}


	@Override
	public void setRequest(Map<String, Object> request) {

		this.request = request;
	}


	@Override
	public void setParameters(Map<String, String[]> parameters) {
		// only can be read, not for write
		this.parameters = parameters;
	}


	@Override
	public void setSession(Map<String, Object> session) {

		this.session = session;
	}
}
