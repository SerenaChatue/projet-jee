package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Emprunt;
import projet.ejb.data.Ouvrage;

public interface IDaoEmprunt {

	int inserer(Emprunt emprunt);

	void modifier(Emprunt emprunt);

	void supprimer(int idEmprunt);

	Emprunt retrouver(int idEmprunt);
	
	List<Ouvrage> listerOuvragesEmpruntes(int idEmprunteur);

	List<Ouvrage> listerOuvragesPretes(int idPreteur);
	
	List<Emprunt> listerTout();
}
