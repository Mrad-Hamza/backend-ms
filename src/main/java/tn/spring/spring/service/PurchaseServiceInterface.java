package tn.spring.spring.service;

import java.util.List;

import tn.spring.spring.entity.Purchase;

public interface PurchaseServiceInterface {
	
	public void addPurchase(Purchase Purchase);
	public void deletePurchase(Purchase Purchase);
	public List<Purchase> getPurchases();
	public Purchase getPurchaseById(Integer id);
	public void updatePurchase(Purchase Purchase);
	public void addOwner(Integer idPurchase,Integer idOwner);

	
}
