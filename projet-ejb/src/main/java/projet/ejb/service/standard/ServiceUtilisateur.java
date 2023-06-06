package projet.ejb.service.standard;

import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;


import projet.commun.dto.DtoUtilisateur;
import projet.commun.exception.ExceptionValidation;
import projet.commun.service.IServiceUtilisateur;
import projet.ejb.dao.IDaoUtilisateur;
import projet.ejb.data.Utilisateur;
import projet.ejb.data.mapper.IMapperEjb;

@Stateless
@Remote
public class ServiceUtilisateur implements IServiceUtilisateur {

	// Champs
	@Inject
	private IMapperEjb mapper;
	@Inject
	private IDaoUtilisateur daoUtilisateur;

	// Actions

	@Override
	public int inserer(DtoUtilisateur dtoUtilisateur) throws ExceptionValidation {
		verifierValiditeDonnees(dtoUtilisateur);
		int id = daoUtilisateur.inserer(mapper.map(dtoUtilisateur));
		return id;
	}

	@Override
	public void modifier(DtoUtilisateur dtoUtilisateur) throws ExceptionValidation {
		verifierValiditeDonnees(dtoUtilisateur);
		daoUtilisateur.modifier(mapper.map(dtoUtilisateur));
	}

	@Override
	public void supprimer(int idUtilisateur) throws ExceptionValidation {
		daoUtilisateur.supprimer(idUtilisateur);
	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public DtoUtilisateur retrouver(int idUtilisateur) {
		Utilisateur auteur = daoUtilisateur.retrouver(idUtilisateur);
		return mapper.map(auteur);

	}

	@Override
	@TransactionAttribute(NOT_SUPPORTED)
	public List<DtoUtilisateur> listerTout() {
		List<DtoUtilisateur> liste = new ArrayList<>();
		for (Utilisateur auteur : daoUtilisateur.listerTout()) {
			liste.add( mapper.map(auteur) );
		}
		return liste;
	}

	// Méthodes auxiliaires

	private void verifierValiditeDonnees(DtoUtilisateur dtoUtilisateur) throws ExceptionValidation {

		StringBuilder message = new StringBuilder();

		if (dtoUtilisateur.getNomUtilisateur() == null || dtoUtilisateur.getNomUtilisateur().isEmpty()) {
			message.append("\nLe nom est absent.");
		} else if (dtoUtilisateur.getNomUtilisateur().length() > 25) {
			message.append("\nLe nom est trop long.");
		}

		if (message.length() > 0) {
			throw new ExceptionValidation(message.toString().substring(1));
		}
	}

}
