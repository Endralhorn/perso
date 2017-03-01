package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import model.Voiture;

@Repository("voitureDAO")
public class DAOVoiture {
	
	EntityManager em ;
	
	public List<Voiture> findAll(){
		
		return this.em
		
	}
	
	

}
