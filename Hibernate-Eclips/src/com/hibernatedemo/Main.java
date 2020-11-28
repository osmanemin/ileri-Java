package com.hibernatedemo;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class Main {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			// from Product where UnitPrice=3000 OR UnitPrice=385
			// from Product where Name LIKE 'a%'
			// from Product where Name LIKE '_i%'
			// from Product p where p.name='Bilgisayar'
			// from Product p ORDER BY p.name DESC
			// select p.name, p.unitPrice from Product p GROUP BY p.name
			/*
			 * List<String> products =
			 * session.createQuery("select p.name from Product p GROUP BY p.name").
			 * getResultList();
			 * 
			 * for(String str : products) { System.out.println(str); }
			 */
			
			// insert
			/*
			 * Product product = new Product(); product.setName("koltuk");
			 * product.setStockAmount(48); product.setUnitPrice(1399);
			 * session.save(product);
			 */			
			
			// update
			
			/*
			 * Product product = session.get(Product.class, 5);
			 * System.out.println(product.getUnitPrice());
			 * product.setUnitPrice(1000);
			 * session.save(product);
			 * System.out.println(product.getUnitPrice());
			 */
			
			// delete
			
			Product product = session.get(Product.class, 5);
			session.delete(product);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			factory.close();
		}
		

	}

}
