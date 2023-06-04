package projet.ejb.dao;

import java.util.List;

import projet.ejb.data.Amitie;

public interface IDaoAmitie {

	int			inserer( Amitie amitie );

	void 		modifier( Amitie amitie );

	void 		supprimer( int idAmitie );

	Amitie 	retrouver( int idAmitie );

	List<Amitie> listerTout();
	
	List<Amitie> listerAmis(int idUser);
}
