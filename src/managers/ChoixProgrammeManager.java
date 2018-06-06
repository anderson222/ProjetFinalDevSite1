package managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import beans.Programme;
import services.ConnecteurBD;

public class ChoixProgrammeManager {

	/************* Queries *********/
	private static String queryAfficherChoixsProgramme = "select * from programme where is_affiche = 1;";

	/************ Fonctions ***************/
	public static ArrayList<Programme> afficherChoixsProgramme() {

		ArrayList<Programme>listeChoixProgramme=new ArrayList<>();

		PreparedStatement ps=ConnecteurBD.getPs(queryAfficherChoixsProgramme);

		try {

			ResultSet result=ps.executeQuery();

			if(result.isBeforeFirst()) {
				while(result.next()){

					Programme programme=new Programme();

					programme.setId(result.getInt(1));
					programme.setDescription(result.getString(2));
					programme.setIs_affiche(result.getBoolean(3));

					listeChoixProgramme.add(programme);
				}
			}

			result.close();
			ps.close();

			ConnecteurBD.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listeChoixProgramme;
	}

}
