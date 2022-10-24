package tn.spring.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.spring.spring.entity.Role;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Person implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String last_name;
	
	private Date birth_date;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private Source source;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Salesman salesman;
	
	@OneToMany(mappedBy="owner")
	private List<Feedback> feedbacks;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="owner")
	private List<Purchase> purchases;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="owner")
	private List<Promotion> promotions;
	
	
	
	
}
