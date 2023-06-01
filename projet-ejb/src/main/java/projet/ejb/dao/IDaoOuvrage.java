package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Ouvrage;


public interface IDaoOuvrage {

	int			inserer( Ouvrage ouvrage );

	void 		modifier( Ouvrage ouvrage );

	void 		supprimer( int idOuvrage );
	
	int         compterPourCategorie (int idCategorie );

	Ouvrage 		retrouver( int idOuvrage );

	List<Ouvrage> listerTout();

}
