package projet.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoUtilisateur implements Serializable {

	// Champs
	
	private int id;
	
	private String nomUtilisateur;
	
	private String prenomUtilisateur;
	
	//Constructeur
	
	public DtoUtilisateur() {
	}
	
	public DtoUtilisateur(int id, String nomUtilisateur, String prenomUtilisateur) {
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
