package com.example.demo;

import javax.persistence.EntityManager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootApplication
@EnableTransactionManagement
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner cmd(EntityManager em, PlatformTransactionManager ptm, DemoService ds, TrxService trxSrv)
	{
		return args -> {
			TransactionTemplate transactionManager = new TransactionTemplate(ptm);
//			transactionManager.executeWithoutResult(action->{
//				CustomerEntity ce = new CustomerEntity();
//				ce.setName("cus1");
//				em.persist(ce);
//				//
//				OrderEntity oe = new OrderEntity();
//				oe.setOrderNo("1111");
//				oe.setCustomer(ce);
//				em.persist(oe);
//			});
//			transactionManager.executeWithoutResult(action->{
//			CustomerEntity saveCustomer = ds.saveCustomer();
//			ds.saveOrder(saveCustomer);
//			});
			trxSrv.save();
		};
	}
	
	
	
}
