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
	@Column( name = "idauteur" )
	private int	id;
	
	@Column( name = "nomauteur" )
	private String	nomauteur;
	
	public Auteur() {
	}

	public Auteur(int id, String nomauteur) {
		super();
		setId(id);
		setNomauteur(nomauteur);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomauteur() {
		return nomauteur;
	}

	public void setNomauteur(String nomauteur) {
		this.nomauteur = nomauteur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nomauteur);
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
				&& Objects.equals(nomauteur, other.nomauteur);
	}

	@Override
	public String toString() {
		return "Auteur [id=" + id + ", nomauteur=" + nomauteur + "]";
	}
	
	
}
