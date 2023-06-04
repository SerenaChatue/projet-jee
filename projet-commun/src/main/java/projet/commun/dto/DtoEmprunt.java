package projet.commun.dto;

import java.io.Serializable;
import java.sql.Date;

public class DtoEmprunt implements Serializable {

	// Champs
	private int id;
	
	private int delai;
	
	private Date dateemprunt;
	
	private DtoUtilisateur preteur;
	
	private DtoUtilisateur emprunteur;
	
	private DtoOuvrage ouvrage;
	
	//Constructeur
	
	public DtoEmprunt() {
	}

	public DtoEmprunt(int id, int delai, Date dateemprunt, DtoUtilisateur preteur, DtoUtilisateur emprunteur,
			DtoOuvrage ouvrage) {
		super();
		this.id = id;
		this.delai = delai;
		this.dateemprunt = dateemprunt;
		this.preteur = preteur;
		this.emprunteur = emprunteur;
		this.ouvrage = ouvrage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public Date getDateemprunt() {
		return dateemprunt;
	}

	public void setDateemprunt(Date dateemprunt) {
		this.dateemprunt = dateemprunt;
	}

	public DtoUtilisateur getPreteur() {
		return preteur;
	}

	public void setPreteur(DtoUtilisateur preteur) {
		this.preteur = preteur;
	}

	public DtoUtilisateur getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(DtoUtilisateur emprunteur) {
		this.emprunteur = emprunteur;
	}

	public DtoOuvrage getOuvrage() {
		return ouvrage;
	}

	public void setOuvrage(DtoOuvrage ouvrage) {
		this.ouvrage = ouvrage;
	}
}
