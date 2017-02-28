package fr.m2i.DAO;

import java.util.List;

import fr.m2i.model.Cletest;

public interface ICletestDAO extends IDAO<Cletest, String>{
	
	public List<Cletest> findAll();
	public Cletest find(String id);
	public Cletest save(Cletest obj);
	public void delete(Cletest obj);

}
