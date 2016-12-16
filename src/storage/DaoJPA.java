package storage;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import service.LivrePOJO;

@Stateless
public class DaoJPA<T> implements DaoJPARemote, Serializable  {

	@PersistenceContext(name="oreilly")
	private EntityManager em;
	public DaoJPA() {
		System.out.println("=============== OUTPUT Source::JPA ===============");
	}
	
	@Override
	public LivrePOJO select(int id) {
		return (LivrePOJO) em.createNamedQuery("produit.Select").setParameter("cle",id).getSingleResult();
	}

	@Override
	public List<LivrePOJO> selectAll() {
		return em.createNamedQuery("produit.All").getResultList();
	}

	@Override
	public void edit(LivrePOJO obj) {
		em.merge(obj);
	}

	@Override
	public void delete(LivrePOJO obj) {
		em.remove(obj);

	}

	@Override
	public void insert(LivrePOJO obj) {
		em.persist(obj);
	}

}