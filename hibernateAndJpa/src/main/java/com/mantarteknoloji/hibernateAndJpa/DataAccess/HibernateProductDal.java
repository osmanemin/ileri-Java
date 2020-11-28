package com.mantarteknoloji.hibernateAndJpa.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mantarteknoloji.hibernateAndJpa.Entities.Product;

@Repository
public class HibernateProductDal implements IProductDal{

	private EntityManager entityManager; 
	
	
	@Autowired
	public HibernateProductDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	

	@Override
	@Transactional
	public List<Product> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Product> products = session.createQuery("from Product", Product.class).getResultList();
		return products;
	}

	@Override
	public void add(Product product) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(product);
	}

	@Override
	public void update(Product product) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(product);
		
	}

	@Override
	public void delete(Product product) {
		Session session = entityManager.unwrap(Session.class);
		Product productToDelete = session.get(Product.class, product.getId());
		session.delete(productToDelete);		
	}


	@Override
	public Product getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Product product = session.get(Product.class, id);
		return product;
	}
	
	

}
