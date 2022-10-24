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
import tn.spring.spring.entity.Purchase;
import tn.spring.spring.service.PersinServiceImpl;
import tn.spring.spring.service.PurchaseServiceImpl;

@RestController
public class PurchaseRestController {
	@Autowired
	PurchaseServiceImpl purchaseService;
	
	@Autowired
	PersinServiceImpl personService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addPurchase")	
	@ResponseBody
	public void addPurchase(@RequestBody Purchase p) {
		purchaseService.addPurchase(p);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getPurchaseById/{id}")
	@ResponseBody
	public Purchase getPurchaseById(@PathVariable Integer id) {
		return purchaseService.getPurchaseById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAllPurchases")
	@ResponseBody
	public List<Purchase> getPurchases() {
		return purchaseService.getPurchases();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updatePurchase/{id}")
	@ResponseBody
	public void updatePurchase(@RequestBody Purchase p,@PathVariable Integer id){
		Purchase purchase = purchaseService.getPurchaseById(id);
		purchase.setPromotion(p.getPromotion());
		purchase.setPurchase_date(p.getPurchase_date());
		purchase.setValue(p.getValue());
		purchaseService.updatePurchase(purchase);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/purchase/setOwner/{idOwner}/{idPurchase}")
	@ResponseBody
	public void setPurchaseOwner(@RequestBody Feedback f,@PathVariable Integer idOwner,@PathVariable Integer idPurchase){
		personService.addPurchase(idPurchase, idOwner);
		purchaseService.addOwner(idPurchase, idOwner);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deletePurchase/{id}")
	@ResponseBody
	public void deletePurchase(@PathVariable Integer id) {
		Purchase p = purchaseService.getPurchaseById(id);
		purchaseService.deletePurchase(p);		
	}
}
