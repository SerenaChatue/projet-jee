package projet.jsf.data;


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table( name = "editeur"  )
public class Editeur implements Serializable{

	Integer id;
	
	@NotBlank( message = "Le pseudo doit être renseigné")
	@Size(max=25, message = "Valeur trop longue pour le pseuo : 25 car. maxi" )
	private String	nomEditeur;
	
	
	public Editeur() {
	}
	public Editeur(Integer id, String nomEditeur) {
		super();
		this.id = id;
		this.nomEditeur = nomEditeur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomEditeur() {
		return nomEditeur;
	}

	public void setNomEditeur(String nomEditeur) {
		this.nomEditeur = nomEditeur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nomEditeur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Editeur other = (Editeur) obj;
		return id == other.id
				&& Objects.equals(nomEditeur, other.nomEditeur);
	}

	@Override
	public String toString() {
		return "Editeur [id=" + id + ", nomediteur=" + nomEditeur + "]";
	}
	
	
}
