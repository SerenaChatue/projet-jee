package projet.ejb.data;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "utilisateur"  )
public class Utilisateur {
	@Id
	@Column( name = "idcompte" )
	private int	id;
	
	@Column( name = "nomutilisateur" )
	private String nomUtilisateur;
	
	@Column( name = "prenomutilisateur" )
	private String prenomUtilisateur;
	
	public Utilisateur() {
	}

	public Utilisateur(int id, String nomUtilisateur, String prenom) {
		super();
		setId(id);
		setNomUtilisateur(nomUtilisateur);
		setPrenomUtilisateur(prenom);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nomUtilisateur, prenomUtilisateur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return id == other.id && Objects.equals(nomUtilisateur, other.nomUtilisateur) && Objects.equals(prenomUtilisateur, other.prenomUtilisateur);
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nomUtilisateur=" + nomUtilisateur + ", prenom=" + prenomUtilisateur + "]";
	}
	
	
}
