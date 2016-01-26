package com.tony.struts2.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;

public class TestActionContextAction {

	public String execute(){
		
		//0. Gain ActionContext object
		//ActionContext is the object of Action, so we can take all information from current Action
		ActionContext actionContext = ActionContext.getContext();
		
		//1. Gain the Map of application, and add an attribute in it
		//Get applicationMap by invoking ActionContext object's getApplication() method
		Map<String, Object> applicationMap = actionContext.getApplication();
		
		//set attribute
		applicationMap.put("applicationKey", "applicationValue");
		
		//gain attribute
		Object date = applicationMap.get("date");
		System.out.println("date: " + date);
		
		
		//2. session
		Map<String, Object> sessionMap = actionContext.getSession();
		sessionMap.put("sessionKey", "sessionValue");
		
		System.out.println(sessionMap.getClass());
		
		if(sessionMap instanceof SessionMap){
			SessionMap sm = (SessionMap) sessionMap;
			sm.invalidate();
			System.out.println("session is invalidate.");
			
		}
		
		
		//3. request
		//There is no such method called getRequest() to get the map of request in ActionContext
		//So we need to invoke get() method and pass "request" String for gaining
		//Notice: 1. the result of getParameters() is Map<String, Object> rather than Map<String, String[]>
		//		  2. the Map of parameters can only be read, not for writing. If write something in it, will not work nor error alarm 
		Map<String, Object> requestMap = (Map<String, Object>) actionContext.get("request");
		requestMap.put("requestKey", "requestValue");
		
		//4. Gain the Map of parameters, and get the specific ones
		//Key: the requesting parameter's name; Value: the String array for the requesting parameter  
	
		Map<String, Object> parameters = actionContext.getParameters();
		System.out.println(((String[])parameters.get("name"))[0]);
		
		parameters.put("age", 100);
		
		
		return "success";
		
	}
	
}
