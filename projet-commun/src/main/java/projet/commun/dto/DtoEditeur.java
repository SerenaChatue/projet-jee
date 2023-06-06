package projet.commun.dto;

import java.io.Serializable;



@SuppressWarnings("serial")
public class DtoEditeur implements Serializable {
	
	
	// Champs
	
	private int				idEditeur;
	
	private String			nomEditeur;
	
	
	
	
	// Constructeurs
	
	public DtoEditeur() {
	}

	public DtoEditeur(int id, String nom) {
		super();
		this.idEditeur = id;
		this.nomEditeur = nom;
		
	}
	
	
	
	// Getters & setters

	public int getId() {
		return idEditeur;
	}

	public void setId(int id) {
		this.idEditeur = id;
	}

	public String getNomEditeur() {
		return nomEditeur;
	}

	public void setNomEditeur(String nom) {
		this.nomEditeur = nom;
	}

	
}
