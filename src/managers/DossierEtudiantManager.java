package managers;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import services.ConnecteurBD;


public class DossierEtudiantManager {

	public static int id_etudiant;


	/************* Queries *********/
	private static String queryAjouterDossierEtudiant = "insert into dossier_etudiant (prenom, nom, courriel) values (?, ?, ?);";
	private static String queryAjouterFichier = "insert into fichier (id_dossier_etudiant, path, dossier_contenant, categorie,format, date) values (?, ?, ?,?, ?, ?);";


	/************ Fonctions ***************/
	public static void ajouterDossierEtudiant(String prenom,String nom,String courriel) {
		PreparedStatement ps=ConnecteurBD.getPsId(queryAjouterDossierEtudiant,Statement.RETURN_GENERATED_KEYS);

		try {
			ps.setString(1, prenom);
			ps.setString(2, nom);
			ps.setString(3, courriel);

			ps.executeUpdate();

			ResultSet result=ps.getGeneratedKeys();

			while(result.next()){
				id_etudiant=result.getInt(1);
				System.out.println("Id etudiant insere : "+id_etudiant);
			}

			result.close();
			ps.close();

			ConnecteurBD.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void ajouterFichier(int id_dossier_etudiant, ArrayList<String> path,String dossier_contenant,String categorie,String format, java.sql.Timestamp date ) {
		PreparedStatement ps=ConnecteurBD.getPs(queryAjouterFichier);

		try {
			
			
			for (int i = 0; i < path.size(); i++) {
				ps.setInt(1, id_dossier_etudiant);
				ps.setString(2, path.get(i));
				ps.setString(3, dossier_contenant);
				ps.setString(4, categorie);
				ps.setString(5, format);
				ps.setTimestamp(6, date);
				ps.executeUpdate();
			}
		
			

			
			ps.close();

			ConnecteurBD.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
