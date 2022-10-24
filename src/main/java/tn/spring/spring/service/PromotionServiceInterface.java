package tn.spring.spring.service;

import java.util.List;

import tn.spring.spring.entity.Promotion;

public interface PromotionServiceInterface {
	public void addPromotion(Promotion Promotion);
	public void deletePromotion(Promotion Promotion);
	public List<Promotion> getPromotions();
	public Promotion getPromotionById(Integer id);
	public void updatePromotion(Promotion Promotion);
	public void addOwner(Integer idPromotion,Integer idOwner);
}
