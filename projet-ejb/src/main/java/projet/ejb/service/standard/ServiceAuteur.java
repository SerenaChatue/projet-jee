package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;


import projet.commun.dto.DtoAuteur;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceAuteur;
import projet.ejb.dao.IDaoAuteur;
import projet.ejb.data.Auteur;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceAuteur implements IServiceAuteur {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoAuteur daoAuteur;

	// Actions

	@Override
	public int inserer(DtoAuteur dtoAuteur) throws ExceptionValidation {
		verifierValiditeDonnees(dtoAuteur);
		int id = daoAuteur.inserer(mapper.map(dtoAuteur));
		return id;
	}

	@Override
	public void modifier(DtoAuteur dtoAuteur) throws ExceptionValidation {
		verifierValiditeDonnees(dtoAuteur);
		daoAuteur.modifier(mapper.map(dtoAuteur));
	}

	@Override
	public void supprimer(int idAuteur) throws ExceptionValidation {
		daoAuteur.supprimer(idAuteur);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoAuteur retrouver(int idAuteur) {
		Auteur auteur = daoAuteur.retrouver(idAuteur);
		return mapper.map(auteur);

	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoAuteur> listerTout() {
		List<DtoAuteur> liste = new ArrayList<>();
		for (Auteur auteur : daoAuteur.listerTout()) {
			liste.add( mapper.map(auteur) );
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoAuteur dtoAuteur) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoAuteur.getNom() == null || dtoAuteur.getNom().isEmpty()) {
			message.append("\nLe nom est absent.");
		} else if (dtoAuteur.getNom().length() > 25) {
			message.append("\nLe nom est trop long.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
