package com.npci;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ProductDAO;
import com.model.Product;

@RestController
public class ProductController {
	
	@Autowired
	ProductDAO prodDAO;

	@RequestMapping("/showProduct")
	public Product showProduct() {
		Product product = new Product(101, "Laptop", 4545.45,"oneplus","assets/images/10001.jpg");
		return product;
	}
	
	@RequestMapping("/showAllProducts")
	public List<Product> showAllProducts() {
		List<Product> prodList = prodDAO.getAllProducts();
		return prodList;
	}
	
	@RequestMapping("/getProdById/{prodId}")
	public Product getProdById(@PathVariable("prodId") int prodId) {
		
		Product product = prodDAO.getProduct(prodId);
		
		if (product != null)
			return product;
		
		return new Product(0, "Product Not Found!!!", 0.0,"","");
	}
	
	
	@RequestMapping("/getProdByName/{prodName}")
	public Product getProdByName(@PathVariable("prodName") String prodName) {
		
		Product product = prodDAO.getProdByName(prodName);
		
		if (product != null)
			return product;
		
		return new Product(0, "Product Not Found!!!", 0.0,"","");
	}
	
	@PostMapping("/registerProduct")
	public Product registerProduct(@RequestBody Product product) {
		return prodDAO.register(product);
	}
	
	@DeleteMapping("/deleteById/{prodId}")
    public Product deleteProductById(@PathVariable("prodId") int prodId) {
    	Product product = prodDAO.getProduct(prodId);
    	if(product != null){
    		prodDAO.deleteById(prodId);
    		return new Product(0,"Succesfully deleted",0.0,"","");
    	}
    	return new Product(0,"Record not found",0.0,"","");
    }
	
	
	@PutMapping("/updateProduct/{prodId}")
    public void updateProduct(@PathVariable int prodId, @RequestBody Product product) {
        product.setProductId(prodId);
        prodDAO.updateProduct(product);
         
        
    }


	
	
	/*@RequestMapping("/showAllProducts")
	public List<Product> showAllProducts() {
		
		List<Product> productList = new ArrayList<Product>();
		
		Product product1 = new Product(101, "Laptop", 4545.45);
		Product product2 = new Product(101, "Laptop", 4545.45);
		Product product3 = new Product(101, "Laptop", 4545.45);
		
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		
		return productList;
	}*/

}

