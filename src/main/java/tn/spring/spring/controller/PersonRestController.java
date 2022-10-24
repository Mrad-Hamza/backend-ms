package tn.spring.spring.controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.spring.spring.entity.Person;
import tn.spring.spring.service.PersinServiceImpl;


@RestController
public class PersonRestController {

	@Autowired
	PersinServiceImpl personService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addPerson")	
	@ResponseBody
	public void addProject(@RequestBody Person p) {
		personService.addPerson(p);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getPersonById/{id}")
	@ResponseBody
	public Person getPersonById(@PathVariable Integer id) {
		return personService.getPersonById(id);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAllPersons")
	@ResponseBody
	public List<Person> getPersons() {
		return personService.getPersons();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAllPersonsBySalesmanId/{id}")
	@ResponseBody
	public List<Person> getPersonsBySalesmanId(@PathVariable Integer id) {
		return personService.getPersonsBySalesmanId(id);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updatePerson/{id}")
	@ResponseBody
	public void updatePerson(@RequestBody Person p,@PathVariable Integer id){
		Person person = personService.getPersonById(id);
		person.setSalesman(p.getSalesman());
		person.setBirth_date(p.getBirth_date());
		person.setLast_name(p.getLast_name());
		person.setName(p.getName());
		person.setRole(p.getRole());
		person.setSource(p.getSource());
		person.setFeedbacks(p.getFeedbacks());
		person.setPromotions(p.getPromotions());
		person.setPurchases(p.getPurchases());
		personService.updatePerson(person);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deletePerson/{id}")
	@ResponseBody
	public void deletePerson(@PathVariable Integer id) {
		System.out.println("aaaaaaaaa");
		Person p = personService.getPersonById(id);
		System.out.println(p);
		personService.deletePerson(p);		
	}
	
}
