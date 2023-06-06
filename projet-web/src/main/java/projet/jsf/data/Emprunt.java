package projet.jsf.data;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emprunt")
public class Emprunt {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idemprunt")
	private int id;

	@Column(name = "delai")
	private int delai;

	@Column(name = "dateemprunt")
	private Date dateemprunt;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idpreteur")
	private Utilisateur preteur;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idemprunteur")
	private Utilisateur emprunteur;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idouvrage")
	private Ouvrage ouvrage;

	public Emprunt() {
	}

	public Emprunt(int id, int delai, Date dateemprunt, Utilisateur preteur, Utilisateur emprunteur, Ouvrage ouvrage) {
		super();
		this.id = id;
		this.delai = delai;
		this.dateemprunt = dateemprunt;
		this.preteur = preteur;
		this.emprunteur = emprunteur;
		this.ouvrage = ouvrage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public Date getDateemprunt() {
		return dateemprunt;
	}

	public void setDateemprunt(Date dateemprunt) {
		this.dateemprunt = dateemprunt;
	}

	public Utilisateur getPreteur() {
		return preteur;
	}

	public void setPreteur(Utilisateur preteur) {
		this.preteur = preteur;
	}

	public Utilisateur getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Utilisateur emprunteur) {
		this.emprunteur = emprunteur;
	}

	public Ouvrage getOuvrage() {
		return ouvrage;
	}

	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateemprunt, delai, emprunteur, id, ouvrage, preteur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprunt other = (Emprunt) obj;
		return Objects.equals(dateemprunt, other.dateemprunt) && delai == other.delai
				&& Objects.equals(emprunteur, other.emprunteur) && id == other.id
				&& Objects.equals(ouvrage, other.ouvrage) && Objects.equals(preteur, other.preteur);
	}

}
