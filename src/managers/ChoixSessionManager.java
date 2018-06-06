package managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import beans.Session;
import services.ConnecteurBD;

public class ChoixSessionManager {

	/************* Queries *********/
	private static String queryAfficherChoixsSession = "select * from session where is_affiche = 1;";

	/************ Fonctions ***************/
	public static ArrayList<Session> afficherChoixsSession() {

		ArrayList<Session>listeChoixSession=new ArrayList<>();

		PreparedStatement ps=ConnecteurBD.getPs(queryAfficherChoixsSession);

		try {

			ResultSet result=ps.executeQuery();

			if(result.isBeforeFirst()) {
				while(result.next()){

					Session session=new Session();

					session.setId(result.getInt(1));
					session.setDescription(result.getString(2));
					session.setIs_affiche(result.getBoolean(3));

					listeChoixSession.add(session);
				}
			}

			result.close();
			ps.close();

			ConnecteurBD.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listeChoixSession;
	}

}
