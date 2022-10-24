package tn.spring.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.spring.entity.Person;
import tn.spring.spring.entity.Purchase;
import tn.spring.spring.entity.Salesman;
import tn.spring.spring.repository.PersonRepository;
import tn.spring.spring.repository.SalesmanRepository;

@Service
public class SalesmanServiceImpl implements SalesmanServiceInterface {
	
	@Autowired
	SalesmanRepository SalesmanRepository;
	
	@Autowired
	PersonRepository personRepository;

	@Override
	public void addSalesman(Salesman Salesman) {
		SalesmanRepository.save(Salesman);
	}

	@Override
	public void deleteSalesman(Salesman Salesman) {
		// TODO Auto-generated method stub
		SalesmanRepository.delete(Salesman);
	}

	@Override
	public List<Salesman> getSalesmans() {
		// TODO Auto-generated method stub
		return SalesmanRepository.findAll();
	}

	@Override
	public Salesman getSalesmanById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Salesman> optinalEntity =  SalesmanRepository.findById(id);
		return optinalEntity.get();
	}

	@Override
	public void updateSalesman(Salesman Salesman) {
		SalesmanRepository.save(Salesman);
	}

	@Override
	public void addPerson(Integer idPerson, Integer idSalesman) {
		Optional<Salesman> optinalSalesmanEntity =  SalesmanRepository.findById(idSalesman);
		Salesman salesman = optinalSalesmanEntity.get();
		Optional<Person> optinalPersonEntity =  personRepository.findById(idPerson);
		Person owner = optinalPersonEntity.get();
		List<Person> clients = salesman.getClients();
		clients.add(owner);
		salesman.setClients(clients);
		SalesmanRepository.save(salesman);
	}
}
