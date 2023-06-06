package projet.jsf.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "categorie"  )
public class Categorie {
	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "idcategorie" )
	private int	id;
	
	@Column( name = "libelle" )
	private String	libelle;
	
	public Categorie() {
	}

	public Categorie(int id, String libelle) {
		super();
		setId(id);
		setLibelle(libelle);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
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
		return id == other.id && Objects.equals(libelle, other.libelle);
	}

	@Override
	public String toString() {
		return "Categorie [id=" + id + ", libelle=" + libelle + "]";
	}
}
