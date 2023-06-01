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
@Table( name = "ouvrage"  )
public class Ouvrage {

	// Champs
	
	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "idouvrage" )
	private int	id;
	
	@Column( name = "nomouvrage" )
	private String nom;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "idAuteur" )
	private Auteur auteur;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcategorie")
	private Categorie categorie;

	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "idcompte" )
	private Utilisateur	utilisateur;

	public Ouvrage() {
	}

	public Ouvrage(int id, String nom, projet.ejb.data.Categorie categorie, Utilisateur utilisateur) {
		super();
		this.id = id;
		this.nom = nom;
		this.categorie = categorie;
		this.utilisateur = utilisateur;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(id, nom, utilisateur);
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
		return id == other.id && Objects.equals(nom, other.nom) && Objects.equals(utilisateur, other.utilisateur);
	}
	
	
}
