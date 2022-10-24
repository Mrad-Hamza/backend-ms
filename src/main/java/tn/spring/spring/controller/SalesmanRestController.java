package tn.spring.spring.controller;

import java.util.List;

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

import tn.spring.spring.entity.Feedback;
import tn.spring.spring.entity.Salesman;
import tn.spring.spring.service.PersinServiceImpl;
import tn.spring.spring.service.SalesmanServiceImpl;

@RestController
public class SalesmanRestController {
	@Autowired
	SalesmanServiceImpl salesmanService;
	
	@Autowired
	PersinServiceImpl personService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addsalesman")	
	@ResponseBody
	public void addsalesman(@RequestBody Salesman p) {
		salesmanService.addSalesman(p);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getsalesmanById/{id}")
	@ResponseBody
	public Salesman getsalesmanById(@PathVariable Integer id) {
		return salesmanService.getSalesmanById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAllsalesmans")
	@ResponseBody
	public List<Salesman> getsalesmans() {
		return salesmanService.getSalesmans();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updatesalesman/{id}")
	@ResponseBody
	public void updatesalesman(@RequestBody Salesman s,@PathVariable Integer id){
		Salesman salesman = salesmanService.getSalesmanById(id);
		salesman.setBonus(s.getBonus());
		salesman.setFirst_name(s.getFirst_name());
		salesman.setLast_name(s.getLast_name());
		salesman.setPhone_numver(s.getPhone_numver());
		salesman.setSalary(s.getSalary());
		salesmanService.updateSalesman(salesman);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/salesman/setClient/{idClient}/{idSalesman}")
	@ResponseBody
	public void setSalesman(@RequestBody Feedback f,@PathVariable Integer idClient,@PathVariable Integer idSalesman){
		personService.setSalesman(idSalesman, idClient);
		salesmanService.addPerson(idClient, idSalesman);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deletesalesman/{id}")
	@ResponseBody
	public void deletesalesman(@PathVariable Integer id) {
		Salesman s = salesmanService.getSalesmanById(id);
		salesmanService.deleteSalesman(s);		
	}
}
