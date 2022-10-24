package tn.spring.spring.service;
import java.util.List;

import tn.spring.spring.entity.Person;


public interface PersonServiceInterface {
	
	public void addPerson(Person person);
	public void deletePerson(Person person);
	public List<Person> getPersons();
	public Person getPersonById(Integer id);
	public void updatePerson(Person person);
	public void setSalesman(Integer idSalesman,Integer idPerson);
	public void addFeedback(Integer idFeedback, Integer idPerson);
	public void addPromotion(Integer idPromotion, Integer idPerson);
	public void addPurchase(Integer idPurchase, Integer idPerson);
	public List<Person> getPersonsBySalesmanId(Integer idSalesman);
	

}
