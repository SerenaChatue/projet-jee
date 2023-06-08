package projet.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoAuteur implements Serializable {
	
	
	// Champs
	
	private int				id;
	
	private String			nomAuteur;
	
	
	
	
	// Constructeurs
	
	public DtoAuteur() {
	}

	public DtoAuteur(int id, String nomAuteur) {
		super();
		this.id = id;
		this.nomAuteur = nomAuteur;
		
	}
	
	
	
	// Getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomAuteur() {
		return nomAuteur;
	}

	public void setNomAuteur(String nom) {
		this.nomAuteur = nom;
	}

	
}
