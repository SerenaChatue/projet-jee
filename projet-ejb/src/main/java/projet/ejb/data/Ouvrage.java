/**
 * 
 */
package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

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
@Entity
@Table(name = "ouvrage")
public class Ouvrage {

	// Champs

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idouvrage")
	private int id;

	@Column(name = "nomouvrage")
	private String nomOuvrage;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idAuteur")
	private Auteur auteur;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcategorie")
	private Categorie categorie;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcompte")
	private Utilisateur utilisateur;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idediteur")
	private Editeur editeur;

	public Ouvrage() {
	}

	public Ouvrage(int id, String nom, projet.ejb.data.Categorie categorie, Utilisateur utilisateur, Editeur editeur) {
		super();
		this.id = id;
		this.nomOuvrage = nom;
		this.categorie = categorie;
		this.utilisateur = utilisateur;
		this.editeur = editeur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNomOuvrage() {
		return nomOuvrage;
	}

	public void setNomOuvrage(String nomOuvrage) {
		this.nomOuvrage = nomOuvrage;
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

	@Override
	public int hashCode() {
		return Objects.hash(auteur, categorie, editeur, id, nomOuvrage, utilisateur);
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
				&& Objects.equals(editeur, other.editeur) && id == other.id && Objects.equals(nomOuvrage, other.nomOuvrage)
				&& Objects.equals(utilisateur, other.utilisateur);
	}

}
