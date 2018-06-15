package action;

import java.util.ArrayList;

import managers.DossierEtudiantManager;

public class AjouterFichierAction {
	
	public static void ajouterFichier(int id_dossier_etudiant, ArrayList<String> path,String dossier_contenant,String categorie,String format, java.sql.Timestamp date) {
		DossierEtudiantManager.ajouterFichier(id_dossier_etudiant, path, dossier_contenant, categorie, format, date);
	}
	
}
