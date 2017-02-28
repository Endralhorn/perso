package fr.m2i.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.m2i.model.Personne;

@Repository
@Transactional
public class PersonneDAO implements IDAO<Personne, Integer>{

	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Personne> findAll() {
		try {
			return this.entityManager.createQuery("from Personne", Personne.class).getResultList();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Personne find(Integer id) {
		try {
			return this.entityManager.find(Personne.class, id);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Personne save(Personne personne) {
		try {
			return this.entityManager.merge(personne);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return personne;
	}

	@Override
	public void delete(Personne personne) {
		try {
			this.entityManager.remove(this.entityManager.merge(personne));
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
