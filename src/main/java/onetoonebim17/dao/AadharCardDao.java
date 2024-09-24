package onetoonebim17.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoonebim17.dto.AadharCard;
import onetoonebim17.dto.Person;

public class AadharCardDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
	}
	
	
	public void updateAadhar(int id,AadharCard aadharCard) {
		EntityManager entityManager=getEntityManager();
		AadharCard dbAadharCard=entityManager.find(AadharCard.class, id);
		if(dbAadharCard!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			
			aadharCard.setId(id);
			aadharCard.setPerson(dbAadharCard.getPerson());
			
			
			entityManager.merge(aadharCard);
			entityTransaction.commit();
		}else {
			System.out.println("sorry id is not present");
		}
	}
}
