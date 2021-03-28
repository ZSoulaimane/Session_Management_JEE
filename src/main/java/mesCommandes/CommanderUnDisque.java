package mesCommandes;
import java.io.*;
import java.text.*;
import java.util.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CommanderUnDisque")
public class CommanderUnDisque extends HttpServlet  {
	
	public void doGet(HttpServletRequest  request,HttpServletResponse response)throws IOException, ServletException{
		String nom = null;
		Integer nbreProduit = 0;
		Cookie  [] cookies = ((HttpServletRequest) request).getCookies();
		nom = Identification.verifier(cookies);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<head>");
		out.println("<title> votre commande </title>");
		out.println("</head>");
		out.println("<body bgcolor=\"white\">");
		out.println("<h3>" + "Bonjour "+ nom + " voici votre commande" + "</h3>");
		
		HttpSession session = request.getSession();

		Enumeration<String> names = session.getAttributeNames();
		
		while (names.hasMoreElements()) {
			
			nbreProduit++;
			String name = (String) names.nextElement();
			String value = session.getAttribute(name).toString();
			out.println(name + " = " + value + "<br>");
		}
		nbreProduit++;
		String articleCode = (String) request.getParameter("code");
		session.setAttribute("article"+nbreProduit.toString(), articleCode);
		out.println("article"+nbreProduit.toString() + " = " + articleCode + "<br>");

		out.println("<A HREF=achat> Vous pouvez commandez un autre disque </A><br> ");
		out.println("<A HREF=enregistre> Vous pouvez enregistrer votre commande </A><br> ");
		out.println("</body>");
		out.println("</html>");
	}
public void doPost(HttpServletRequest  request,HttpServletResponse response)throws IOException, ServletException{doGet(request, response);}
}
