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
import tn.spring.spring.service.FeedbackserviceImpl;
import tn.spring.spring.service.PersinServiceImpl;

@RestController
public class FeedbackRestController {
	@Autowired
	FeedbackserviceImpl feedbackService;
	
	@Autowired
	PersinServiceImpl personService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addFeedback")	
	@ResponseBody
	public void addFeedback(@RequestBody Feedback f) {
		feedbackService.addFeedback(f);
	}
	
	@GetMapping("/getFeedbackById/{id}")
	@ResponseBody
	public Feedback getFeedbackById(@PathVariable Integer id) {
		return feedbackService.getFeedbackById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getAllFeedbacks")
	@ResponseBody
	public List<Feedback> getFeedbacks() {
		return feedbackService.getFeedbacks();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updateFeedback/{id}")
	@ResponseBody
	public void updateFeedback(@RequestBody Feedback f,@PathVariable Integer id){
		Feedback feedback = feedbackService.getFeedbackById(id);
		feedback.setDescription(f.getDescription());
		feedback.setTitle(f.getTitle());
		feedback.setType(f.getType());
		feedbackService.updateFeedback(feedback);
	}
	
	@PutMapping("/feedback/setOwner/{idOwner}/{idFeedback}")
	@ResponseBody
	public void setFeedbackOwner(@RequestBody Feedback f,@PathVariable Integer idOwner,@PathVariable Integer idFeedback){
		feedbackService.setPerson(idFeedback, idOwner);
		personService.addFeedback(idFeedback, idOwner);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteFeedback/{id}")
	@ResponseBody
	public void deleteFeedback(@PathVariable Integer id) {
		Feedback f = feedbackService.getFeedbackById(id);
		feedbackService.deleteFeedback(f);		
	}
}
