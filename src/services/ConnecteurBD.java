package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnecteurBD {

	/************ Attributs pour la connexion ****************/
	private final static String urlConnection = "jdbc:mysql://localhost:3306/bd_etudiants_etrangers";
	private final static String login = "root";
	private final static String pwd = "abc123...";

	private static Connection connexion;


	/************* Fonction pour les requêtes sql préparées **************/
	public static PreparedStatement getPsId(String query,int id) {
		PreparedStatement retour=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connexion=DriverManager.getConnection(urlConnection, login, pwd);
			System.out.println(connexion);
			retour=connexion.prepareStatement(query,id);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retour;

	}

	public static PreparedStatement getPs(String query) {
		PreparedStatement retour=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			connexion=DriverManager.getConnection(urlConnection, login, pwd);
			System.out.println(connexion);
			retour=connexion.prepareStatement(query);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retour;

	}


	/************ Fonction pour fermer la connexion ***********/
	public static void close() {
		try {
			connexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
