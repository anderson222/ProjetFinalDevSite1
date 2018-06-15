package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.DossierEtudiantAction;

/**
 * Servlet implementation class SoumettreDossierEtudiantServlet
 */
@WebServlet("/SoumettreDossierEtudiantServlet")
@MultipartConfig(/*fileSizeThreshold=1024*1024*10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100*/)   
public class SoumettreDossierEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SoumettreDossierEtudiantServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String	urlRetour="AfficherProgrammeSessionServlet";
	
		if(DossierEtudiantAction.creeDossierEtudiantConnecte(request, response)){				
			urlRetour="confirmation.jsp";		
		
		request.getRequestDispatcher(urlRetour).forward(request, response);
		}
	}
}
