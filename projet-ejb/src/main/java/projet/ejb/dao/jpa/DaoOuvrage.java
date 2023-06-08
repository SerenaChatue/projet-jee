package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoOuvrage;
import projet.ejb.data.Ouvrage;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoOuvrage implements IDaoOuvrage {

	
	// Champs
	
	@PersistenceContext
	private EntityManager	em;
	
	
	// Actions
	
	@Override
	public int inserer(Ouvrage ouvrage) {
		em.persist(ouvrage);
		em.flush();
		return ouvrage.getId();
	}

	@Override
	public void modifier(Ouvrage ouvrage) {
		ouvrage.setUtilisateur(null);
		em.merge( ouvrage );
	}

	@Override
	public void supprimer(int idOuvrage) {
		em.remove( retrouver(idOuvrage) );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public Ouvrage retrouver(int idOuvrage) {
		return em.find( Ouvrage.class, idOuvrage );
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public List<Ouvrage> listerTout() {
		em.clear();
		var jpql = "SELECT o FROM Ouvrage o";
		var query = em.createQuery( jpql, Ouvrage.class );
		System.out.println(query.getResultList().toString());
		return query.getResultList();
	}

	@Override
	@TransactionAttribute( NOT_SUPPORTED )
	public int compterPourCategorie(int idCategorie) {
		var jpql = "SELECT COUNT(p) FROM Ouvrage p WHERE p.categorie.id = :idCategorie";
		var query = em.createQuery( jpql, Long.class );
		query.setParameter( "idCategorie", idCategorie );
		return query.getSingleResult().intValue();
	}
	
}
