package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoEditeur;
import projet.ejb.data.Editeur;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoEditeur implements IDaoEditeur {
	
	// Champs
	@PersistenceContext
	private EntityManager em;
	

	// Actions
	
	@Override
	public int inserer(Editeur editeur) {
//		editeur.setId( donnees.getProchainIdEditeur() );
//		affecterIdTelephones(editeur);
//		donnees.getMapEditeurs().put( editeur.getId(), editeur );
//		return editeur.getId();
		em.persist(editeur);
		em.flush();
		return editeur.getId();
	}

	@Override
	public void modifier(Editeur editeur) {
//		affecterIdTelephones(editeur);
//		donnees.getMapEditeurs().replace( editeur.getId(), editeur );
		em.merge(editeur);
	}

	@Override
	public void supprimer(int idEditeur) {
		//donnees.getMapEditeurs().remove( idEditeur );
		em.remove(em.getReference(Editeur.class, idEditeur));
	}

	@Override
	public Editeur retrouver(int idEditeur) {
		//return donnees.getMapEditeurs().get( idEditeur );
		return em.find(Editeur.class,idEditeur);
	}

	@Override
	public List<Editeur> listerTout() {
		//return  trierParNom( new ArrayList<>(donnees.getMapEditeurs().values() ) );
		return em.createQuery("SELECT p FROM Editeur p ORDER BY p.nom",Editeur.class).getResultList();
	}


	

}
