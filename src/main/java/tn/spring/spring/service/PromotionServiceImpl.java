package tn.spring.spring.service;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.spring.spring.repository.PersonRepository;
import tn.spring.spring.repository.PromotionRepository;
import tn.spring.spring.repository.PromotionRepository;
import tn.spring.spring.entity.Feedback;
import tn.spring.spring.entity.Person;
import tn.spring.spring.entity.Promotion;
import tn.spring.spring.entity.Promotion;

@Service
public class PromotionServiceImpl implements PromotionServiceInterface {
	@Autowired
	PromotionRepository PromotionRepository;
	
	@Autowired
	PersonRepository personRepository;

	@Override
	public void addPromotion(Promotion Promotion) {
		PromotionRepository.save(Promotion);
	}

	@Override
	public void deletePromotion(Promotion Promotion) {
		// TODO Auto-generated method stub
		PromotionRepository.delete(Promotion);
	}

	@Override
	public List<Promotion> getPromotions() {
		// TODO Auto-generated method stub
		return PromotionRepository.findAll();
	}

	@Override
	public Promotion getPromotionById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Promotion> optinalEntity =  PromotionRepository.findById(id);
		return optinalEntity.get();
	}

	@Override
	public void updatePromotion(Promotion Promotion) {
		PromotionRepository.save(Promotion);
	}

	@Override
	public void addOwner(Integer idPromotion, Integer idOwner) {
		Optional<Promotion> optinalPromotionEntity =  PromotionRepository.findById(idPromotion);
		Promotion promotion = optinalPromotionEntity.get();
		Optional<Person> optinalPersonEntity =  personRepository.findById(idOwner);
		Person owner = optinalPersonEntity.get();
		promotion.setOwner(owner);
		PromotionRepository.save(promotion);
	}
}
