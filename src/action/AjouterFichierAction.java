package action;

import java.sql.Date;

import managers.DossierEtudiantManager;

public class AjouterFichierAction {

	public static void ajouterFichier(int id_dossier_etudiant, String path,String dossier_contenant,String categorie,String format) {
		DossierEtudiantManager.ajouterFichier(id_dossier_etudiant, path, dossier_contenant, categorie, format);
	}
	
}
