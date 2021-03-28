package mesCommandes;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Identification")
public class Identification {
	static String chercheNom (Cookie  [] cookies) {
		
		String nom = null;
		
		for (Cookie aCookie : cookies) {
		    String name = aCookie.getName();
		 
		    if (name.equals("nomCookie")) {
		        nom = aCookie.getValue();
		        return nom;
		    }
		}
		return "inconnu";
		}

	public static String verifier(Cookie[] cookies) {
		// TODO Auto-generated method stub
		return null;
	}
	}