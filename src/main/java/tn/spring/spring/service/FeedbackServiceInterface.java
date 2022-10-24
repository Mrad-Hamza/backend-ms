package tn.spring.spring.service;

import java.util.List;

import tn.spring.spring.entity.Feedback;

public interface FeedbackServiceInterface {
	
	public void addFeedback(Feedback Feedback);
	public void deleteFeedback(Feedback Feedback);
	public List<Feedback> getFeedbacks();
	public Feedback getFeedbackById(Integer id);
	public void updateFeedback(Feedback Feedback);
	public void setPerson(Integer idFeedback,Integer idPerson);

}
