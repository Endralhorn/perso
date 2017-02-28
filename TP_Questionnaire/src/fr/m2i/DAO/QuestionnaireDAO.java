package fr.m2i.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.m2i.model.Question;
import fr.m2i.model.Questionnaire;

@Repository
@Transactional
public class QuestionnaireDAO implements IDAO<Questionnaire, Integer>{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<Questionnaire> findAll() {
		try {
			return this.entityManager.createQuery("from Question", Question.class).getResultList();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Questionnaire find(Integer id) {
		try {
			return this.entityManager.find(Question.class, id);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Questionnaire save(Questionnaire obj) {
		try {
			return this.entityManager.merge(question);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return question;
	}

	@Override
	public void delete(Questionnaire obj) {
		try {
			this.entityManager.remove(this.entityManager.merge(question));
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
