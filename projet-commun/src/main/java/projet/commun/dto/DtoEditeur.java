package projet.commun.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DtoEditeur implements Serializable {
	
	
	// Champs
	
	private int				id;
	
	private String			nomEditeur;
	
	
	
	
	// Constructeurs
	
	public DtoEditeur() {
	}

	public DtoEditeur(int id, String nomEditeur) {
		super();
		this.id = id;
		this.nomEditeur = nomEditeur;
		
	}
	
	
	
	// Getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomEditeur() {
		return nomEditeur;
	}

	public void setNomEditeur(String nom) {
		this.nomEditeur = nom;
	}

	
}
