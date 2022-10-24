package tn.spring.spring.service;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.spring.spring.repository.FeedbackRepository;
import tn.spring.spring.repository.PersonRepository;
import tn.spring.spring.repository.FeedbackRepository;
import tn.spring.spring.repository.FeedbackRepository;
import tn.spring.spring.entity.Feedback;
import tn.spring.spring.entity.Person;
import tn.spring.spring.entity.Feedback;
import tn.spring.spring.entity.Feedback;

@Service
public class FeedbackserviceImpl implements FeedbackServiceInterface {
	
	@Autowired
	FeedbackRepository FeedbackRepository;
	
	@Autowired
	PersonRepository personRepository;

	@Override
	public void addFeedback(Feedback Feedback) {
		FeedbackRepository.save(Feedback);
	}

	@Override
	public void deleteFeedback(Feedback Feedback) {
		// TODO Auto-generated method stub
		FeedbackRepository.delete(Feedback);
	}

	@Override
	public List<Feedback> getFeedbacks() {
		// TODO Auto-generated method stub
		return FeedbackRepository.findAll();
	}

	@Override
	public Feedback getFeedbackById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Feedback> optinalEntity =  FeedbackRepository.findById(id);
		return optinalEntity.get();
	}

	@Override
	public void updateFeedback(Feedback Feedback) {
		FeedbackRepository.save(Feedback);
	}

	@Override
	public void setPerson(Integer idFeedback, Integer idPerson) {
		Optional<Feedback> optinalFeedbackEntity =  FeedbackRepository.findById(idFeedback);
		Feedback feedback = optinalFeedbackEntity.get();
		Optional<Person> optinalPersonEntity =  personRepository.findById(idPerson);
		Person owner = optinalPersonEntity.get();
		feedback.setOwner(owner);
		FeedbackRepository.save(feedback);
	}
}
