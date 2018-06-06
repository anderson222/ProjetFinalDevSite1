package managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Session;
import services.ConnecteurBD;

public class AdmissionSessionLinkManager {

	/************* Queries *********/
	private static String queryAfficherChoixSessionEtudiant = "select * from session where description like ?;";
	private static String queryAjouterChoixSession = "insert into admission_session_link (id_session, id_dossier_etudiant) values (?, ?);";

	/************ Fonctions ***************/
	public static void ajouterChoixSession(List<String> sessions) {

		/****** Pour recuperer les id de la table session *******/
		ArrayList<Session>liste=new ArrayList<>();

		PreparedStatement ps=ConnecteurBD.getPs(queryAfficherChoixSessionEtudiant);

		try {
			for (int i=0;i<sessions.size();i++) {
				ps.setString(1, sessions.get(i));
				ResultSet result=ps.executeQuery();


				if(result.isBeforeFirst()) {
					while(result.next()) {
						Session sess= new Session();
						sess.setId(result.getInt(1));
						liste.add(sess);
					}
				}
				
				result.close();
			}

			ps.close();

			/****** Pour ajouter les id recuperes dans la table admission_session_link *******/
			PreparedStatement pstatement=ConnecteurBD.getPs(queryAjouterChoixSession);

			for (int i = 0; i < liste.size(); i++) {
				pstatement.setInt(1, liste.get(i).getId());
				pstatement.setInt(2,DossierEtudiantManager.id_etudiant);

				pstatement.executeUpdate();
			}

			pstatement.close();

			ConnecteurBD.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
