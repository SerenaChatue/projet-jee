package projet.jsf.data;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "utilisateur"  )
public class Utilisateur {
	 Integer	id;

	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

private String nomUtilisateur;
	
	private String prenomUtilisateur;
	
	//Constructeur
	
	
	
	public Utilisateur(int id, String nomUtilisateur, String prenomUtilisateur) {
		super();
		this.id = id;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
	}

	//Getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}
	
	
	
	
}
