package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "auteur"  )
public class Auteur {
	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "idAuteur" )
	private int	id;
	
	@Column( name = "nomAuteur" )
	private String	nomAuteur;
	
	public Auteur() {
	}

	public Auteur(int id, String nomauteur) {
		super();
		setId(id);
		setNomAuteur(nomauteur);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomAuteur() {
		return nomAuteur;
	}

	public void setNomAuteur(String nomauteur) {
		this.nomAuteur = nomauteur;
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
