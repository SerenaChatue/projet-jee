package projet.commun.dto;

public class DtoAmitie {

	private int id;
	
	private boolean demandeEnvoyee;
	
	private boolean demandeAcceptee;
	
	private DtoUtilisateur sender;
	
	private DtoUtilisateur receiver;
	
	public DtoAmitie() {
	}

	public DtoAmitie(int id, boolean demandeEnvoyee, boolean demandeAcceptee, DtoUtilisateur sender,
			DtoUtilisateur receiver) {
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

	public DtoUtilisateur getSender() {
		return sender;
	}

	public void setSender(DtoUtilisateur sender) {
		this.sender = sender;
	}

	public DtoUtilisateur getReceiver() {
		return receiver;
	}

	public void setReceiver(DtoUtilisateur receiver) {
		this.receiver = receiver;
	}
}
