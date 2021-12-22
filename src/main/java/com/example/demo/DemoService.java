package com.example.demo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService {

	EntityManager em;

	@Autowired
	public DemoService(EntityManager em) {
		this.em = em;
	}

//	@Transactional(propagation = Propagation.REQUIRES_NEW)// lead to customer insertion
	@Transactional
	public CustomerEntity saveCustomer() {
		CustomerEntity ce = new CustomerEntity();
		ce.setName("cus100");
		em.persist(ce);
//		saveOrder(ce);
		return ce;
	}

	@Transactional
	public void saveOrder(CustomerEntity cus) {
		OrderEntity oe = new OrderEntity();
		oe.setOrderNo("5555555555");
		oe.setCustomer(cus);
		em.persist(oe);
		throw new RuntimeException("dsfsd");
	}

}
