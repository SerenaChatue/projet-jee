package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;


import projet.commun.dto.DtoEditeur;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceEditeur;
import projet.ejb.dao.IDaoEditeur;
import projet.ejb.data.Editeur;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceEditeur implements IServiceEditeur {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoEditeur daoEditeur;

	// Actions

	@Override
	@TransactionAttribute( TransactionAttributeType.REQUIRED)
	public int inserer(DtoEditeur dtoEditeur) throws ExceptionValidation {
		verifierValiditeDonnees(dtoEditeur);
		int id = daoEditeur.inserer(mapper.map(dtoEditeur));
		return id;
	}

	@Override
	@TransactionAttribute( TransactionAttributeType.REQUIRED)
	public void modifier(DtoEditeur dtoEditeur) throws ExceptionValidation {
		verifierValiditeDonnees(dtoEditeur);
		daoEditeur.modifier(mapper.map(dtoEditeur));
	}

	@Override
	public void supprimer(int idEditeur) throws ExceptionValidation {
		daoEditeur.supprimer(idEditeur);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoEditeur retrouver(int idEditeur) {
		Editeur editeur = daoEditeur.retrouver(idEditeur);
		return mapper.map(editeur);

	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoEditeur> listerTout() {
		List<DtoEditeur> liste = new ArrayList<>();
		for (Editeur editeur : daoEditeur.listerTout()) {
			liste.add( mapper.map(editeur) );
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoEditeur dtoEditeur) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoEditeur.getNomEditeur() == null || dtoEditeur.getNomEditeur().isEmpty()) {
			message.append("\nLe nom est absent.");
		} else if (dtoEditeur.getNomEditeur().length() > 25) {
			message.append("\nLe nom est trop long.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
