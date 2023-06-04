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

@Entity
@Table( name = "editeur" )
public class Amitie {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idami")
	private int id;
	
	@Column(name = "demande_envoyee")
	private boolean demandeEnvoyee;
	
	@Column(name = "demande_acceptee")
	private boolean demandeAcceptee;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sender_id")
	private Utilisateur sender;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receiver_id")
	private Utilisateur receiver;
	
	public Amitie() {}

	public Amitie(int id, boolean demandeEnvoyee, boolean demandeAcceptee, Utilisateur sender, Utilisateur receiver) {
		super();
		this.id = id;
		this.demandeEnvoyee = demandeEnvoyee;
		this.demandeAcceptee = demandeAcceptee;
		this.sender = sender;
		this.receiver = receiver;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isDemandeEnvoyee() {
		return demandeEnvoyee;
	}

	public void setDemandeEnvoyee(boolean demandeEnvoyee) {
		this.demandeEnvoyee = demandeEnvoyee;
	}

	public boolean isDemandeAcceptee() {
		return demandeAcceptee;
	}

	public void setDemandeAcceptee(boolean demandeAcceptee) {
		this.demandeAcceptee = demandeAcceptee;
	}

	public Utilisateur getSender() {
		return sender;
	}

	public void setSender(Utilisateur sender) {
		this.sender = sender;
	}

	public Utilisateur getReceiver() {
		return receiver;
	}

	public void setReceiver(Utilisateur receiver) {
		this.receiver = receiver;
	}

	@Override
	public int hashCode() {
		return Objects.hash(demandeAcceptee, demandeEnvoyee, id, receiver, sender);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amitie other = (Amitie) obj;
		return demandeAcceptee == other.demandeAcceptee && demandeEnvoyee == other.demandeEnvoyee && id == other.id
				&& Objects.equals(receiver, other.receiver) && Objects.equals(sender, other.sender);
	}
}
