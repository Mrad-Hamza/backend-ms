package tn.spring.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.spring.spring.entity.Person;
import tn.spring.spring.entity.Promotion;
import tn.spring.spring.entity.Purchase;
import tn.spring.spring.entity.Purchase;
import tn.spring.spring.repository.PersonRepository;
import tn.spring.spring.repository.PurchaseRepository;
import tn.spring.spring.repository.PurchaseRepository;

@Service
public class PurchaseServiceImpl implements PurchaseServiceInterface {

	@Autowired
	PurchaseRepository purchaseRepository;

	@Autowired
	PersonRepository personRepository;

	@Override
	public void addPurchase(Purchase Purchase) {
		purchaseRepository.save(Purchase);
	}

	public void deletePurchase(Purchase Purchase) {
		// TODO Auto-generated method stub
		purchaseRepository.delete(Purchase);
	}

	@Override
	public List<Purchase> getPurchases() {
		// TODO Auto-generated method stub
		return purchaseRepository.findAll();
	}

	@Override
	public Purchase getPurchaseById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Purchase> optinalEntity =  purchaseRepository.findById(id);
		return optinalEntity.get();
	}

	@Override
	public void updatePurchase(Purchase Purchase) {
		purchaseRepository.save(Purchase);
	}

	@Override
	public void addOwner(Integer idPurchase, Integer idOwner) {
		Optional<Purchase> optinalPurchaseEntity =  purchaseRepository.findById(idPurchase);
		Purchase purchase = optinalPurchaseEntity.get();
		Optional<Person> optinalPersonEntity =  personRepository.findById(idOwner);
		Person owner = optinalPersonEntity.get();
		purchase.setOwner(owner);
		purchaseRepository.save(purchase);
		
	}
	

}
