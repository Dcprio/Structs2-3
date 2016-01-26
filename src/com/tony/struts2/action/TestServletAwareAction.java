package com.tony.struts2.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;


/**
 * To invoke ServletXxxAware interfaces, we can use Struts2 to inject those necessary Servlet Objects
 * 
 * ServletRequestAware: Inject HttpServletRequest Object(usually)
 * ServletContextAware: Inject ServletContext Object (usually)
 * ServletResponseAware: Inject ServletResponse　Object
 * 
 * 
 * 
 * @author tony
 *
 */


public class TestServletAwareAction 
	implements ServletRequestAware, ServletContextAware, ServletResponseAware{

	private ServletContext context;
	
	@Override
	public void setServletContext(ServletContext arg0) {

		this.context =  arg0;
		System.out.println(arg0);
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0);
		
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0);
		
	}
	
	public String execute(){
		System.out.println("ServletContext: " + context);
		
		return "success";
	}

}
