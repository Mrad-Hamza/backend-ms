package tn.spring.spring.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.spring.spring.repository.FeedbackRepository;
import tn.spring.spring.repository.PersonRepository;
import tn.spring.spring.repository.PromotionRepository;
import tn.spring.spring.repository.PurchaseRepository;
import tn.spring.spring.repository.SalesmanRepository;
import tn.spring.spring.entity.Feedback;
import tn.spring.spring.entity.Person;
import tn.spring.spring.entity.Promotion;
import tn.spring.spring.entity.Purchase;
import tn.spring.spring.entity.Salesman;

@Service
public class PersinServiceImpl implements PersonServiceInterface{
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Autowired
	PromotionRepository promotionRepository;
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	@Autowired
	SalesmanRepository salesmanRepository;

	@Override
	public void addPerson(Person person) {
		personRepository.save(person);
	}

	@Override
	public void deletePerson(Person person) {
		// TODO Auto-generated method stub
		personRepository.delete(person);
	}

	@Override
	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		System.out.println(personRepository.findAll());
		return personRepository.findAll();
	}

	@Override
	public Person getPersonById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Person> optinalEntity =  personRepository.findById(id);
		return optinalEntity.get();
	}

	@Override
	public void updatePerson(Person person) {
		personRepository.save(person);
	}

	@Override
	public void setSalesman(Integer idSalesman, Integer idPerson) {
		Optional<Salesman> optinalSalesmanEntity =  salesmanRepository.findById(idSalesman);
		Salesman salesman = optinalSalesmanEntity.get();
		Optional<Person> optinalPersonEntity =  personRepository.findById(idPerson);
		Person person = optinalPersonEntity.get();
		person.setSalesman(salesman);
		personRepository.save(person);
	}

	@Override
	public void addFeedback(Integer idFeedback, Integer idPerson) {
		Optional<Feedback> optinalFeedbackEntity =  feedbackRepository.findById(idFeedback);
		Feedback feedback = optinalFeedbackEntity.get();
		Optional<Person> optinalPersonEntity =  personRepository.findById(idPerson);
		Person person = optinalPersonEntity.get();
		List<Feedback> feedbacks = person.getFeedbacks();
		feedbacks.add(feedback);
		person.setFeedbacks(feedbacks);
		personRepository.save(person);
	}

	@Override
	public void addPromotion(Integer idPromotion, Integer idPerson) {
		Optional<Promotion> optinalPromotionEntity =  promotionRepository.findById(idPromotion);
		Promotion promotion = optinalPromotionEntity.get();
		Optional<Person> optinalPersonEntity =  personRepository.findById(idPerson);
		Person person = optinalPersonEntity.get();
		List<Promotion> promotions = person.getPromotions();
		promotions.add(promotion);
		person.setPromotions(promotions);
		personRepository.save(person);
	}

	@Override
	public void addPurchase(Integer idPurchase, Integer idPerson) {
		Optional<Purchase> optinalPurchaseEntity =  purchaseRepository.findById(idPurchase);
		Purchase purchase = optinalPurchaseEntity.get();
		Optional<Person> optinalPersonEntity =  personRepository.findById(idPerson);
		Person person = optinalPersonEntity.get();
		List<Purchase> purchases = person.getPurchases();
		purchases.add(purchase);
		person.setPurchases(purchases);
		personRepository.save(person);
	}

	@Override
	public List<Person> getPersonsBySalesmanId(Integer idSalesman) {
		Optional<Salesman> optinalSalesmanEntity =  salesmanRepository.findById(idSalesman);
		Salesman salesman = optinalSalesmanEntity.get();
		List<Person> list = personRepository.findBySalesman(salesman);
		System.out.println(list);
		return list ;
	}

}
