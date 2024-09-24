package onetoonebim17.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoonebim17.dto.Person;

public class PersonDao {

	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	
	public void updatePerson(int id,Person person) {
		EntityManager entityManager=getEntityManager();
		Person dbPerson=entityManager.find(Person.class, id);
		if(dbPerson!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			person.setId(id);
			person.setAadharCard(dbPerson.getAadharCard());
			
			entityManager.merge(person);
			entityTransaction.commit();
		}else {
			System.out.println("sorry id is not present");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
