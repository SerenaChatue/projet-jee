package projet.ejb.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import projet.commun.dto.DtoCategorie;
import projet.commun.dto.DtoCompte;
import projet.ejb.data.Categorie;
import projet.ejb.data.Compte;

 
@Mapper( componentModel = "cdi" )
public interface IMapperEjb {  
	
	static final IMapperEjb INSTANCE = Mappers.getMapper( IMapperEjb.class );
	
	
	// Compte
	
	Compte map( DtoCompte source );
	
	DtoCompte map( Compte source );
	
	// Categorie
	
		Categorie map( DtoCategorie source );
		
		DtoCategorie map( Categorie source );
}
