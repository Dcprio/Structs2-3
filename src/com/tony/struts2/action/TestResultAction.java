package com.tony.struts2.action;

public class TestResultAction {

	
	private int number;
	
	public void setNumber(int number){
		
		this.number = number;
		
	}
	
	
	public String execute(){
		
		String result = null;
		
		//Go to different JSP page basing on the number parameter.
		//1. If number is 4, return to success.jsp page
		if(number % 4 == 0)
			result = "success";
		
		//2. If number / 4 == 1, return to login.jsp
		else if(number % 4 == 1)
			result = "login";
		
		//3. If number / 4 == 2, return to index.jsp
		else if(number % 4 == 2)
			result = "index";
		
		else 
			return "test";
		
		
		return result;
	}
	
	
}
