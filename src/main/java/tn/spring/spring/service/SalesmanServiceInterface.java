package tn.spring.spring.service;

import java.util.List;

import tn.spring.spring.entity.Salesman;

public interface SalesmanServiceInterface {
	public void addSalesman(Salesman Salesman);
	public void deleteSalesman(Salesman Salesman);
	public List<Salesman> getSalesmans();
	public Salesman getSalesmanById(Integer id);
	public void updateSalesman(Salesman Salesman);
	public void addPerson(Integer idPerson,Integer idSalesman);

}
