package com.example.demo;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TrxService {


	DemoService ds;
	
	

	public TrxService(DemoService ds) {
		this.ds = ds;
	}

	@Transactional
	public void save() {
		CustomerEntity saveCustomer = ds.saveCustomer();
		ds.saveOrder(saveCustomer);
	}


}
