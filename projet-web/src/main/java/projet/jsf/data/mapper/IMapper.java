package projet.jsf.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import projet.commun.dto.DtoAmitie;
import projet.commun.dto.DtoAuteur;
import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoEmprunt;
import projet.commun.dto.DtoOuvrage;
import projet.commun.dto.DtoUtilisateur;
import projet.jsf.data.Amitie;
import projet.jsf.data.Auteur;
import projet.jsf.data.Compte;
import projet.jsf.data.Emprunt;
import projet.jsf.data.Ouvrage;
import projet.jsf.data.Utilisateur;

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

	// Utilisateur
	Utilisateur map(DtoUtilisateur source);

	Utilisateur duplicate(Utilisateur source);

	Utilisateur update(@MappingTarget Utilisateur target, Utilisateur source);

	DtoUtilisateur map(Utilisateur courant);
	
	//Amitie
	Amitie		map(DtoAmitie source);
	
	Amitie		duplicate(Amitie source);
	
	Amitie		update(@MappingTarget Amitie target, Amitie source);
	
	DtoAmitie	map(Amitie courant);

	//Emprunt
	Emprunt		map(DtoEmprunt source);
	
	Emprunt		duplicate(Emprunt source);
	
	Emprunt		update(@MappingTarget Emprunt target, Emprunt source);
	
	DtoEmprunt	map(Emprunt courant);
}
