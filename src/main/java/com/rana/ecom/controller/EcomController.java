package com.rana.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rana.ecom.constant.IEcomConstant;
import com.rana.ecom.dao.IEcomDao;
import com.rana.ecom.model.Post;
import com.rana.ecom.model.Product;
import com.rana.ecom.model.ServiceResponse;



@Controller
@RequestMapping("/item")
public class EcomController {

	
	@Autowired
	IEcomDao ecomDao;
	
	
	@RequestMapping(value = "/getposts", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Post> getPosts(){
		
		List<Post> posts = ecomDao.getPostsFromDB();
		return posts;
	}
	
	@RequestMapping(value = "/getitembyid/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ServiceResponse getItemById(@PathVariable String id){
		ServiceResponse res = new ServiceResponse();
		try {
			Product product = ecomDao.getProductById(id);
			res.setObj(product);
			res.setStatus(IEcomConstant.SUCCESS);
		} catch (Exception e) {
			res.setStatus(IEcomConstant.FAILED);
			res.setMsg(e.getMessage());
		}
		return res;
	}
	
	
	
	
	

}
