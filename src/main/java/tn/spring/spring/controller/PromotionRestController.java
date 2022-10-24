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
import tn.spring.spring.entity.Promotion;
import tn.spring.spring.service.PersinServiceImpl;
import tn.spring.spring.service.PromotionServiceImpl;

@RestController
public class PromotionRestController {
	@Autowired
	PromotionServiceImpl promotionService;
	
	@Autowired
	PersinServiceImpl personService;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addPromotion")	
	@ResponseBody
	public void addPromotion(@RequestBody Promotion p) {
		promotionService.addPromotion(p);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getPromotionById/{id}")
	@ResponseBody
	public Promotion getPromotionById(@PathVariable Integer id) {
		return promotionService.getPromotionById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAllPromotions")
	@ResponseBody
	public List<Promotion> getPromotions() {
		return promotionService.getPromotions();
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updatePromotion/{id}")
	@ResponseBody
	public void updatePromotion(@RequestBody Promotion p,@PathVariable Integer id){
		Promotion promotion = promotionService.getPromotionById(id);
		promotion.setCode(p.getCode());
		promotion.setPercentage(p.getPercentage());
		promotionService.updatePromotion(promotion);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/promotion/setOwner/{idOwner}/{idPromotion}")
	@ResponseBody
	public void setPromotionOwner(@RequestBody Feedback f,@PathVariable Integer idOwner,@PathVariable Integer idPromotion){
		personService.addPromotion(idPromotion, idPromotion);
		promotionService.addOwner(idPromotion, idOwner);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deletePromotion/{id}")
	@ResponseBody
	public void deletePromotion(@PathVariable Integer id) {
		Promotion p = promotionService.getPromotionById(id);
		promotionService.deletePromotion(p);		
	}
}
