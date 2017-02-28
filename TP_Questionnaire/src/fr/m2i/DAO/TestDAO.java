
package fr.m2i.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.m2i.model.Test;

@Repository
@Transactional
public class TestDAO implements IDAO<Test, Integer> {
	
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Test> findAll() {
		try {
			return this.entityManager.createQuery("from Test", Test.class).getResultList();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Test find(Integer id) {
		try {
			return this.entityManager.find(Test.class, id);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Test save(Test test) {
		try {
			return this.entityManager.merge(test);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return test;
	}

	@Override
	public void delete(Test test) {
		try {
			this.entityManager.remove(this.entityManager.merge(test));
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	

}