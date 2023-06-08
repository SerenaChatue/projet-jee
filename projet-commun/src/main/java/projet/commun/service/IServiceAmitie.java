package projet.commun.service;

import java.util.List;

import projet.commun.dto.DtoAmitie;
import projet.commun.exception.ExceptionValidation;


public interface IServiceAmitie {
	
	int				inserer( DtoAmitie dtoAmitie ) throws ExceptionValidation;
	
	void			modifier( DtoAmitie dtoAmitie ) throws ExceptionValidation;
	
	void			supprimer( int idAmitie ) throws ExceptionValidation;
	
	DtoAmitie 	retrouver( int idAmitie );
	
	List<DtoAmitie> listerTout();
	
	List<DtoAmitie> listerAmis(int idUser);
	
}
