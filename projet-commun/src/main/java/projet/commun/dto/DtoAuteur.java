package projet.commun.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class DtoAuteur implements Serializable {
	
	
	// Champs
	
	private int				idAuteur;
	
	private String			nomAuteur;
	
	
	
	
	// Constructeurs
	
	public DtoAuteur() {
	}

	public DtoAuteur(int id, String nom) {
		super();
		this.idAuteur = id;
		this.nomAuteur = nom;
		
	}
	
	
	
	// Getters & setters

	public int getId() {
		return idAuteur;
	}

	public void setId(int id) {
		this.idAuteur = id;
	}

	public String getNom() {
		return nomAuteur;
	}

	public void setNom(String nom) {
		this.nomAuteur = nom;
	}

	
}
