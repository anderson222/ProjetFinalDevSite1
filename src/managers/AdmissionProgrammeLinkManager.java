package managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Programme;
import services.ConnecteurBD;

public class AdmissionProgrammeLinkManager {

	/************* Queries *********/
	private static String queryAfficherChoixProgrammeEtudiant = "select * from programme where description like ?;";
	private static String queryAjouterChoixProgramme = "insert into admission_programme_link (id_programme, id_dossier_etudiant) values (?, ?);";

	/************ Fonctions ***************/
	public static void ajouterChoixProgramme(List<String>programmes) {

		/****** Pour recuperer les id de la table programme *******/
		ArrayList<Programme>liste=new ArrayList<>();

		PreparedStatement ps=ConnecteurBD.getPs(queryAfficherChoixProgrammeEtudiant);

		try {
			for (int i=0;i<programmes.size();i++) {
				ps.setString(1, programmes.get(i));
				ResultSet result=ps.executeQuery();


				if(result.isBeforeFirst()) {
					while(result.next()) {
						Programme prog= new Programme();
						prog.setId(result.getInt(1));
						liste.add(prog);
					}
				}

				result.close();
			}

			ps.close();

			/****** Pour ajouter les id recuperes dans la table admission_programme_link *******/
			PreparedStatement pstatement=ConnecteurBD.getPs(queryAjouterChoixProgramme);

			for (int i = 0; i <liste.size(); i++) {
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
