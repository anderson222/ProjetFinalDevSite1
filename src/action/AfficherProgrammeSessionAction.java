package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import beans.Programme;
import beans.Session;
import managers.ChoixProgrammeManager;
import managers.ChoixSessionManager;

public class AfficherProgrammeSessionAction {

	public static boolean afficherChoixProgramme(HttpServletRequest request) {

		boolean retour=false;

		ArrayList<Programme>liste_programmes=ChoixProgrammeManager.afficherChoixsProgramme();

		if(liste_programmes!=null) {
			request.setAttribute("liste_programmes", liste_programmes);
			retour=true;
		}

		return retour;
	}

	public static boolean afficherChoixSession(HttpServletRequest request) {

		boolean retour=false;

		ArrayList<Session>liste_sessions=ChoixSessionManager.afficherChoixsSession();

		if(liste_sessions!=null) {
			request.setAttribute("liste_sessions", liste_sessions);
			retour=true;
		}

		return retour;
	}

}
