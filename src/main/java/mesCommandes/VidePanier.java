package mesCommandes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/VidePanier")
public class VidePanier extends HttpServlet  {
	public void doGet(HttpServletRequest  request, HttpServletResponse  response) throws IOException, ServletException {
			HttpSession session = request.getSession();
			if(session != null) {
				session.invalidate();
			}
			((HttpServletResponse) response).sendRedirect("achat");  
		}
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
	doGet(request, response);
 }
}