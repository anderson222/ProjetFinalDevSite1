package managers;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import services.ConnecteurBD;

public class DossierEtudiantManager {

	public static int id_etudiant;
	
		
	

	/************* Queries *********/
	private static String queryAjouterDossierEtudiant = "insert into dossier_etudiant (prenom, nom, courriel) values (?, ?, ?);";

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

	
}
