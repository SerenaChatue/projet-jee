package projet.ejb.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import projet.commun.dto.DtoAuteur;
import projet.commun.dto.DtoCategorie;
import projet.commun.dto.DtoCompte;
import projet.commun.dto.DtoEditeur;
import projet.commun.dto.DtoOuvrage;
import projet.ejb.data.Auteur;
import projet.ejb.data.Categorie;
import projet.ejb.data.Compte;
import projet.ejb.data.Editeur;
import projet.ejb.data.Ouvrage;

@Mapper(componentModel = "cdi")
public interface IMapperEjb {

	static final IMapperEjb INSTANCE = Mappers.getMapper(IMapperEjb.class);

	// Compte

	Compte map(DtoCompte source);

	DtoCompte map(Compte source);

	// Categorie

	Categorie map(DtoCategorie source);

	DtoCategorie map(Categorie source);

	// Auteur

	Auteur map(DtoAuteur source);

	DtoAuteur map(Auteur source);

	// Editeur

	Editeur map(DtoEditeur source);

	DtoEditeur map(Editeur source);

	// Ouvrage

	Ouvrage map(DtoOuvrage source);

	DtoOuvrage map(Ouvrage source);

}
