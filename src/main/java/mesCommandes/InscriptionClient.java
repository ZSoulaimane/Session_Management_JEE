package mesCommandes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/InscriptionClient")
public class InscriptionClient extends HttpServlet  {

	protected void doGet(HttpServletRequest  request, HttpServletResponse   response) throws ServletException , IOException  {
        
		String nomRecu = request.getParameter("nom"), motPasseRecu = request.getParameter("motdepasse");
        String nomCookie = null, motPasseCookie = null;
        
        
        HttpSession  session = request.getSession();
        Cookie[] cookies = request.getCookies();
 

	      
		PrintWriter pwriter = response.getWriter();
		String url = response.encodeURL(request.getContextPath()+"/sinscrire");
		String urlAchat = response.encodeURL(request.getContextPath()+"/achat");

		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
/*		
		Cookie acookie = new Cookie("nomCookie", "");
        acookie.setMaxAge(0);
        response.addCookie(acookie);
        
        Cookie aacookie = new Cookie("passCookie", "");
        aacookie.setMaxAge(0);
        response.addCookie(aacookie);
  */      
        

		if(cookies != null) {
			for (Cookie aCookie : cookies) {
				if (aCookie.getName().equals("nomCookie")) {
					
					nomCookie = aCookie.getValue();
					//aCookie.setMaxAge(0);
					
				}else if (aCookie.getName().equals("passCookie")) {
					motPasseCookie = aCookie.getValue();
					//aCookie.setMaxAge(0);
				}
			}
		}

		if (nomCookie==null && nomRecu==null){ 
		    //pwriter.print("Password: ");
			out.println("<html>");
			out.println("<body>");
			out.println("<head>"); 
			out.println("<title> inscription d'un client </title>");
			out.println("</head>");
			out.println("<body bgcolor='white' >"); 
			out.println( nomRecu +" | "+ motPasseRecu +" | "+ nomCookie +" | "+ motPasseCookie );
			out.println("<h3>" + "Bonjour, vous devez vous inscrire " + "</h3>");
            out.println("<h3>" + "Attention mettre nom et le mot de passe avec plus de 3 caracteres" + "</h3>");
            out.print(" <form action='InscriptionClient' method='GET' > ");
            out.println("nom");
            out.println("<input type='text' size='20' name='nom' >");
            out.println("<br>");
            out.println("mot de passe");
            out.println("<input type='password' size='20' name='motdepasse'> <br>");
            out.println("<input type='submit' value='inscription'>");
			out.println("</form>"); 
			out.println("</body>");
			out.println("</html>");
			
		} else if (nomCookie==null && nomRecu!=null){
				
	            //String nomCookie2 =(String) request.getAttribute("nom"), motPasseCookie2 = (String) request.getAttribute("motdepasse");
	            Cookie c1=new Cookie("nomCookie", nomRecu);
	            Cookie c2=new Cookie("passCookie", motPasseRecu);
	            response.addCookie(c1);
	            response.addCookie(c2);
	            System.out.println("TRUE");
	            out.println("<HTML>" +
	                            "<BODY>\n" +
	                            "<H1 ALIGN=CENTER>" + "Salut dans le 2eme CAS</H1><br>" +
	                            "<div align=\"center\"><h2>Your information : </h2>"+
	                            "<L1><B>Nom:" +nomRecu+ "<br>" +
	                            "<L1><B>Mot de passe:" +motPasseRecu+ "<br>" +
	                            "<a href="+url+" >Click</a>"+
	                            "</div>" + "\n" +
	                            "</BODY>" +
	                            "</HTML>"
	            );
	            log("----------------------------INFO ------------------------------");
	            log( " le nom Recu : "+ request.getAttribute("nom"));
	            log( " mot de passe Recu : "+ request.getAttribute("motdepasse"));
	            log( " Cookie : "+ session.getId());
	           // log( " nom Cookie : "+ nomCookie2);
	           // log( " pass Cookie : "+ motPasseCookie2 );
	            log("----------------------------END------------------------------");

	        }
			else if (identique(nomRecu,nomCookie) && identique(motPasseRecu,motPasseCookie)) 
	        {
				//List<String> panier = new ArrayList<>();
				//session.setAttribute("panier", panier);
				((HttpServletResponse) response).sendRedirect("achat");        
			}
			else {
				out.println("<html>");
				out.println("<body>");
				out.println("<head>"); 
				out.println("<title> inscription d'un client 3 </title>");
				out.println("</head>");
				out.println("<body bgcolor='white' >"); 
				out.println( nomRecu +" | "+ motPasseRecu +" | "+ nomCookie +" | "+ motPasseCookie );
				out.println("<h3>" + "Bonjour, vous devez vous inscrire " + "</h3>");
	            out.println("<h3>" + "Attention mettre nom et le mot de passe avec plus de 3 caracteres" + "</h3>");
	            out.print(" <form action='InscriptionClient' method='GET' > ");
	            out.println("nom");
	            out.println("<input type='text' size='20' name='nom' >");
	            out.println("<br>");
	            out.println("mot de passe");
	            out.println("<input type='password' size='20' name='motdepasse'> <br>");
	            out.println("<input type='submit' value='inscription'>");
				out.println("</form>"); 
				out.println("</body>");
				out.println("</html>");
	            
 
			}
		}
 
public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException { doGet(request, response);}
	boolean identique (String recu, String cookie) {
		return ((recu != null) && (recu.length() >3) && (cookie != null) && (recu.equals(cookie) ));
	}	}