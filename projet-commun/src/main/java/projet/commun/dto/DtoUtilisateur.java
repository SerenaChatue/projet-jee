package projet.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoUtilisateur implements Serializable {

	// Champs
	
	private int id;
	
	private String nom;
	
	private String prenom;
	
	//Constructeur
	
	public DtoUtilisateur() {
	}
	
	public DtoUtilisateur(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	//Getters and setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
