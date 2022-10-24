package tn.spring.spring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.spring.spring.entity.Person;
import tn.spring.spring.entity.Salesman;


@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	
	public List<Person> findBySalesman(Salesman s);
	
	
}
