package projet.ejb.dao.jpa;

import static javax.ejb.TransactionAttributeType.MANDATORY;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import projet.ejb.dao.IDaoAmitie;
import projet.ejb.data.Amitie;


@Stateless
@Local
@TransactionAttribute( MANDATORY )
public class DaoAmitie implements IDaoAmitie {
	
	// Champs
	@PersistenceContext
	private EntityManager em;
	

	// Actions
	
	@Override
	public int inserer(Amitie amitie) {
//		amitie.setId( donnees.getProchainIdAmitie() );
//		affecterIdTelephones(amitie);
//		donnees.getMapAmities().put( amitie.getId(), amitie );
//		return amitie.getId();
		em.persist(amitie);
		em.flush();
		return amitie.getId();
	}

	@Override
	public void modifier(Amitie amitie) {
//		affecterIdTelephones(amitie);
//		donnees.getMapAmities().replace( amitie.getId(), amitie );
		em.merge(amitie);
	}

	@Override
	public void supprimer(int idAmitie) {
		//donnees.getMapAmities().remove( idAmitie );
		em.remove(retrouver(idAmitie));
	}

	@Override
	public Amitie retrouver(int idAmitie) {
		//return donnees.getMapAmities().get( idAmitie );
		return em.find(Amitie.class,idAmitie);
	}

	@Override
	public List<Amitie> listerTout() {
		//return  trierParNom( new ArrayList<>(donnees.getMapAmities().values() ) );
		return em.createQuery("SELECT p FROM Amitie p",Amitie.class).getResultList();
	}

	@Override
	public List<Amitie> listerAmis(int idUser) {
		var jpql = "SELECT a FROM Amitie a WHERE a.sender.id = :idUser or a.receiver.id = :idUser";
		var query = em.createQuery(jpql, Amitie.class);
		query.setParameter("idUser", idUser);
		return query.getResultList();
	}


	

}
