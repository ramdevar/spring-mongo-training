package com.rana.ecom.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.rana.ecom.config.DBManager;
import com.rana.ecom.model.Product;

@Component
public class EcomDaoImpl implements IEcomDao {
	
	@Autowired
	DBManager dbManager;

	

	@Override
	public List<Product> getProductByCategory(String category, int skip, int limit) throws Exception {

		List<Product> products = null;
		Query qry = new Query();
		qry.addCriteria(Criteria.where("category").is(category));
		qry.with(new Sort(Sort.Direction.ASC, "name")).skip(skip).limit(limit);
		
		try {
			products = dbManager.getMongoTemplate().find(qry, Product.class);
		} catch (Exception e) {			
			e.printStackTrace();
			throw e;
		}
		return products;
	}

	@Override
	public Product getProductById(String id) throws Exception{
		Product product = null;
		Query qry = new Query();
		qry.addCriteria(Criteria.where("id").is(id));
		
		try {
			product = dbManager.getMongoTemplate().findOne(qry, Product.class);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		}
		return product;
	}

	@Override
	public Product getProductByName(String name) throws Exception {
		Product product = null;
		Query qry = new Query();
		qry.addCriteria(Criteria.where("name").is(name));
		
		try {
			product = dbManager.getMongoTemplate().findOne(qry, Product.class);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		}
		return product;
	}
	

}
