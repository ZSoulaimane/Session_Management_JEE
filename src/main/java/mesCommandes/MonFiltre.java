package mesCommandes;
import java.io.*;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MonFiltre implements Filter {
	
	private FilterConfig filterConfig = null;
	
	public void init(FilterConfig filterConfig) throws ServletException {this.filterConfig = filterConfig;}
	
	public void doFilter(ServletRequest  request, ServletResponse  response, FilterChain  chain) throws IOException, ServletException {
		String nom = null;
		HttpServletRequest  hrequest = (HttpServletRequest) request;
		HttpServletResponse  hresponse = (HttpServletResponse) response;
		
		Cookie [] cookies = hrequest.getCookies();
		
		for (Cookie aCookie : cookies) {
			
		    String name = aCookie.getName();
		 
		    if (name.equals("nom")) {nom = aCookie.getValue();}
		    
		}
		if (nom==null) { ((HttpServletResponse) response).sendRedirect("sinscrire");}
		
		else {chain.doFilter(request, response); }}
	
	public void destroy(){this.filterConfig = null;}
	
}