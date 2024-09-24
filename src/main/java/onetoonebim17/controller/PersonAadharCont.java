package onetoonebim17.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoonebim17.dto.AadharCard;
import onetoonebim17.dto.Person;

public class PersonAadharCont {
public static void main(String[] args) {
	Person person=new Person();
	person.setId(1);
	person.setName("bhakthi");
	person.setAddress("Mysore");
	
	
	AadharCard aadharCard=new AadharCard();
	aadharCard.setId(100);
	aadharCard.setName("Bhakthissss");
	aadharCard.setAge(17);
	
	person.setAadharCard(aadharCard);
	aadharCard.setPerson(person);
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	
	entityManager.persist(person);
	entityManager.persist(aadharCard);
	
	entityTransaction.commit();
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
