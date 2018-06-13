package beans;

import java.sql.Date;

public class Fichier {
	
	int id;
	int id_dossier_etudiant;
	String path;
	String dossier_contenant;
	String categorie;
	String format;
	Date date;
	
	
	public Fichier() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_dossier_etudiant() {
		return id_dossier_etudiant;
	}


	public void setId_dossier_etudiant(int id_dossier_etudiant) {
		this.id_dossier_etudiant = id_dossier_etudiant;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getDossier_contenant() {
		return dossier_contenant;
	}


	public void setDossier_contenant(String dossier_contenant) {
		this.dossier_contenant = dossier_contenant;
	}


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public String getFormat() {
		return format;
	}


	public void setFormat(String format) {
		this.format = format;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	


}
