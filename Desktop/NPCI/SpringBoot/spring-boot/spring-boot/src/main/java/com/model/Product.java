package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id@GeneratedValue
	private int productId;
	
	@Column(name="prodName",length=30)
	private String productName;
	private double productPrice;
	private String description;
	private String imgPath;

	public Product() {
		super();
	}

	public Product(int productId, String productName, double productPrice, String description, String imgPath) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.description = description;
		this.imgPath = imgPath;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	

	

}

