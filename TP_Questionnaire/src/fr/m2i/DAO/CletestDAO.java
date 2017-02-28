package fr.m2i.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.m2i.model.Cletest;


public class CletestDAO implements ICletestDAO {
	
	@PersistenceContext
	EntityManager entityManager;
	

	@Override
	public List<Cletest> findAll() {
		try {
			return this.entityManager.createQuery("from Cletest", Cletest.class).getResultList();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Cletest find(String id) {
		try {
			return this.entityManager.find(Cletest.class, id);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Cletest save(Cletest cletest) {
		try {
			return this.entityManager.merge(cletest);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return cletest;
	}

	@Override
	public void delete(Cletest cletest) {
		try {
			this.entityManager.remove(this.entityManager.merge(cletest));
		}

		catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public Cletest auth(String cleUnique) {
		return null;
		
	}

}
