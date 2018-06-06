package action;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import managers.DossierEtudiantManager;

public class DossierEtudiantAction {
	private static List<String> choix_programmes = null;
	private static List<String> choix_sessions = null;
	private static String prenom = null;
	private static String nom = null;
	private static String courriel = null;
	
	public static boolean creeDossierEtudiantConnecte(HttpServletRequest request) {
		// TODO Auto-generated method stub
		// DossierEtudiant de = DossierEtudiantManager.creeDossierEtudiant();
		boolean reussi = false;
		choix_programmes = new ArrayList<String>();
		choix_sessions = new ArrayList<String>();
		ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
		try {

			List formItems = sfu.parseRequest(request);
			Iterator it = formItems.iterator();
			while (it.hasNext()) {
				FileItem item = (FileItem) it.next();
				
				if (item.isFormField()) {
					if ("champ_prenom".equals(item.getFieldName())) {
						prenom = item.getString();
						request.setAttribute("prenom", prenom);
					}

					if ("champ_nom".equals(item.getFieldName())) {
						nom = item.getString();
						request.setAttribute("nom", nom);
					}
					if ("champ_courriel".equals(item.getFieldName())) {
						courriel = item.getString();
						request.setAttribute("courriel", courriel);
					}
					
					if ("choix_session".equals(item.getFieldName())) {
						choix_sessions.add(item.getString());
						request.setAttribute("choix_prog", choix_programmes);
					}
					
					if ("choix_programme".equals(item.getFieldName())) {
						choix_programmes.add(item.getString());
						request.setAttribute("choix_session", choix_sessions);
					}
					
				} else {
					String fileName = new File(item.getName()).getName();
					String filePath = "c:\\FicherAdmission\\" + fileName +"_" + prenom;
					File storeFile = new File(filePath);
					// saves the file on disk
					item.write(storeFile);	
				}

			}
			ajouterDossierEtudiant(prenom, nom, courriel, choix_programmes, choix_sessions );
			reussi = true;
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reussi;
	}
	
	public static void ajouterDossierEtudiant(String prenomParam,String nomParam,String courrielParam, List<String>Choix_programmesParam, List<String>choix_sessionsParam){
		DossierEtudiantManager.ajouterDossierEtudiant(prenomParam, nomParam, courrielParam);
		AjouterProgrammeSessionAction.ajouterChoixProgramme(Choix_programmesParam);
		AjouterProgrammeSessionAction.ajouterChoixSession(choix_sessionsParam);
	}

	
}
