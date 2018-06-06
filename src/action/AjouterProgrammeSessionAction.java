package action;

import java.util.List;

import managers.AdmissionProgrammeLinkManager;
import managers.AdmissionSessionLinkManager;

public class AjouterProgrammeSessionAction {

	public static void ajouterChoixProgramme(List<String>programmes) {
		AdmissionProgrammeLinkManager.ajouterChoixProgramme(programmes);
	}
	
	public static void ajouterChoixSession(List<String>sessions) {
		AdmissionSessionLinkManager.ajouterChoixSession(sessions);
	}
	
}
