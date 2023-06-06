package projet.jsf.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import projet.commun.dto.DtoAuteur;
import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoOuvrage;
import projet.jsf.data.Auteur;
import projet.jsf.data.Compte;
import projet.jsf.data.Ouvrage;

@Mapper(componentModel = "cdi")
public interface IMapper {

	// Compte
	Compte duplicate(Compte source);

	Compte update(@MappingTarget Compte target, Compte source);

	DtoCompte map(Compte source);

	Compte map(DtoCompte source);

//ouvrage
	Ouvrage map(DtoOuvrage source);

	DtoOuvrage map(Ouvrage source);

	Ouvrage duplicate(Ouvrage source);

	Ouvrage update(@MappingTarget Ouvrage target, Ouvrage source);

	// auteur
	Auteur map(DtoAuteur source);

	DtoAuteur map(Auteur source);

	Auteur duplicate(Auteur source);

	Auteur update(@MappingTarget Auteur target, Auteur source);

}
