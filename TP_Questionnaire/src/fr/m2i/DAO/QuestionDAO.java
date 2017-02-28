package fr.m2i.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.m2i.model.Question;

@Repository
@Transactional
public class QuestionDAO implements IDAO<Question, Integer>{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Question> findAll() {
		try {
			return this.entityManager.createQuery("from Question", Question.class).getResultList();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Question find(Integer id) {
		try {
			return this.entityManager.find(Question.class, id);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Question save(Question question) {
		try {
			return this.entityManager.merge(question);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return question;
	}

	@Override
	public void delete(Question question) {
		try {
			this.entityManager.remove(this.entityManager.merge(question));
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
