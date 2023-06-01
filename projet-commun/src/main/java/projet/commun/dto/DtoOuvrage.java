package projet.commun.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class DtoOuvrage implements Serializable {
	
	
	// Champs
	
	private int				id;
	
	private String			nomOuvrage;
	
	
	private DtoCategorie	categorie;
	
	private DtoEditeur	editeur;
	
	private DtoAuteur	auteur;
	
	private DtoCompte	compte;
	
	
	
	
	// Constructeurs
	
	public DtoOuvrage() {
	}

	public DtoOuvrage(int id, String nom, DtoCategorie categorie, DtoAuteur auteur, DtoEditeur editeur, DtoCompte compte ) {
		super();
		this.id = id;
		this.nomOuvrage = nom;
		this.categorie = categorie;
		this.auteur = auteur;
		this.editeur = editeur;
		this.compte = compte;
	}
	
	
	
	// Getters & setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomOuvrage() {
		return nomOuvrage;
	}

	public void setNomOuvrage(String nom) {
		this.nomOuvrage = nom;
	}

	public DtoCategorie getCategorie() {
		return categorie;
	}

	public void setCategorie(DtoCategorie categorie) {
		this.categorie = categorie;
	}

	public DtoEditeur getEditeur() {
		return editeur;
	}

	public void setEditeur(DtoEditeur editeur) {
		this.editeur = editeur;
	}

	public DtoAuteur getAuteur() {
		return auteur;
	}

	public void setAuteur(DtoAuteur auteur) {
		this.auteur = auteur;
	}

	public DtoCompte getCompte() {
		return compte;
	}

	public void setCompte(DtoCompte compte) {
		this.compte = compte;
	}

	
}
