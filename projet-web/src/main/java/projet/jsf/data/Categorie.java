package projet.jsf.data;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "categorie")
public class Categorie implements Serializable {

	Integer id;

	@NotBlank(message = "Le pseudo doit être renseigné")
	@Size(max = 25, message = "Valeur trop longue pour le pseuo : 25 car. maxi")
	private String libelle;

	public Categorie() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Categorie(Integer id,
			@NotBlank(message = "Le pseudo doit être renseigné") @Size(max = 25, message = "Valeur trop longue pour le pseuo : 25 car. maxi") String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, libelle);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categorie other = (Categorie) obj;
		return Objects.equals(id, other.id) && Objects.equals(libelle, other.libelle);
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", libelle=" + libelle + "]";
	}

}
