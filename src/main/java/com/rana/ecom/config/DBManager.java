package com.rana.ecom.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;


/**
 * @author Rana
 *
 */
@Component
public class DBManager {

	@Autowired
	EcomConfig ecomConfig;

	// private DBManager(){} // taking care of by spring @Configuration

	public static MongoTemplate artTemplate;
	private static MongoClientOptions mongoOptions;
	private static MongoClient mongo;
	private static MongoDbFactory mongoDbFactory;

	/**
	 * @return MongoTemplate
	 * @throws Exception
	 */
	public MongoTemplate getMongoTemplate() throws Exception {

		if (mongoOptions == null) {
			mongoOptions = new MongoClientOptions.Builder()
					.maxWaitTime(1000 * 60 * 5).connectionsPerHost(200).build();

		}

		ServerAddress sr = null;

		try {
			sr = new ServerAddress(ecomConfig.getDB_HOST(),
					ecomConfig.getDB_PORT());

			List<ServerAddress> srList = new ArrayList<ServerAddress>();
			srList.add(sr);
			//UserCredentials uc = new UserCredentials("ecom", "password");
			MongoCredential credential = MongoCredential.createCredential(ecomConfig.getUser(),
																		ecomConfig.getDB_NAME(),
																		ecomConfig.getPassword().toCharArray());

			List<MongoCredential> mcList = new ArrayList<MongoCredential>();
			mcList.add(credential);
			if (mongo == null) {
				mongo = new MongoClient(srList, mcList, mongoOptions);
			}

			if (mongoDbFactory == null) {
				mongoDbFactory = new SimpleMongoDbFactory(mongo, ecomConfig.getDB_NAME());				
			}

			if (artTemplate == null) {
				artTemplate = new MongoTemplate(mongoDbFactory);
			}
		} catch (Exception e) {
			throw new Exception(e);
		}

		return artTemplate;

	}

}
