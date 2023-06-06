package projet.jsf.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table( name = "auteur"  )
public class Auteur implements Serializable{

	Integer id;
	
	@NotBlank( message = "Le pseudo doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le pseuo : 25 car. maxi" )
	private String	nomAuteur;
	
	
	public Auteur() {
	}
	public Auteur(Integer id, String nomAuteur) {
		super();
		this.id = id;
		this.nomAuteur = nomAuteur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomAuteur() {
		return nomAuteur;
	}

	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nomAuteur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Auteur other = (Auteur) obj;
		return id == other.id
				&& Objects.equals(nomAuteur, other.nomAuteur);
	}

	@Override
	public String toString() {
		return "Auteur [id=" + id + ", nomauteur=" + nomAuteur + "]";
	}
	
	
}
