package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Product;

@Service
public class ProductDAO {

	@Autowired	
	ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		List<Product> prodList = productRepository.findAll();
		return prodList;
	}
	
	public Product getProduct(int prodId) {
		return productRepository.findById(prodId).orElse(null);
	}

	public Product getProdByName(String prodName) {
		
		return productRepository.findByName(prodName);
	}
	
	public Product register(Product product) {
		return productRepository.save(product);
	}
    
	public void deleteById(int prodid) {
		productRepository.deleteById(prodid);
	}

	public void updateProduct(Product product) {
        productRepository.save(product);
    }

	
}

