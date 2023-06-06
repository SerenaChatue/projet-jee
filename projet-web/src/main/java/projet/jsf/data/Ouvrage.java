/**
 * 
 */
package projet.jsf.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author seren
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "ouvrage")
public class Ouvrage implements Serializable {

	// Champs

	private Integer id;

	private String nom;

	private Auteur auteur;

	private Categorie categorie;

	private Utilisateur utilisateur;

	private Editeur editeur;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Editeur getEditeur() {
		return editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}

	public Ouvrage(Integer id, String nom, Auteur auteur, Categorie categorie, Utilisateur utilisateur,
			Editeur editeur) {
		super();
		this.id = id;
		this.nom = nom;
		this.auteur = auteur;
		this.categorie = categorie;
		this.utilisateur = utilisateur;
		this.editeur = editeur;
	}

	public Ouvrage() {
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(auteur, categorie, editeur, id, nom, utilisateur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ouvrage other = (Ouvrage) obj;
		return Objects.equals(auteur, other.auteur) && Objects.equals(categorie, other.categorie)
				&& Objects.equals(editeur, other.editeur) && Objects.equals(id, other.id)
				&& Objects.equals(nom, other.nom) && Objects.equals(utilisateur, other.utilisateur);
	}


}
