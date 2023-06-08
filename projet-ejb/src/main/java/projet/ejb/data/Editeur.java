package projet.ejb.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "editeur"  )
public class Editeur {
	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "idEditeur" )
	private int	id;
	
	@Column( name = "nomEditeur" )
	private String	nomEditeur;
	
	public Editeur() {
	}

	public Editeur(int id, String nomediteur) {
		super();
		setId(id);
		setNomEditeur(nomediteur);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomEditeur() {
		return nomEditeur;
	}

	public void setNomEditeur(String nomediteur) {
		this.nomEditeur = nomediteur;
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
