package beans;

public class NosEnums {
	
	
//	*********** Fichier ****************
	public enum DossierContenant{

		Admission,
		CAQ,
		PermisEtudes

	}
	
	public enum Categories {
		DossierScolaire,
		PlanEtude,
		PreuveFinanciere,
		Autre
	}
	
//********** Paiement ******************
	public enum TypePaiement{
		
		Admission,
		Scolarite,
		Autre
	}
	
	public enum ModePaiement{

		Credit,
		TransfertBancaire,
		Autre
	}
	
//*********** Etats Dossiers *************	
	
	public enum EtatGlobal {

		EnAttente,
		Admis,
		PaiementAdmissionAttendu,
		PaiementAdmissionRecu,
		CAQ,
		PaiementScolariteAttendu,
		PaiementScolariteRecu,
		PermisEtudes,
		Complete

	}

	public enum EtatAdmission {

		Depose,
		Accepte,
		Refuse

	}

	public enum EtatCAQ {
		
		NA,
		Collecte,
		Depose,
		Accepte,
		Refuse,
		Ferme

	}

	public enum EtatPermis {

		NA,
		Collecte,
		Depose,
		DeuxiemeDepot,
		Accepte,
		Refuse,
		Ferme

	}
	
// ***********Recherche *****************
	
	public enum ParamRecherche {
		
		nom,
		courriel,
		etat_global
	}




}
