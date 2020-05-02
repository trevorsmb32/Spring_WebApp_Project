package com.emusicstore.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name="product")
public class Product {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name="productCode")
	String productCode;
	
	@Column(name="productName")
	String name;
	
	@Column(name="productPrice")
	double price;
	
	@Column(name="productDescription")
	String description;
	
	@Column(name="quantity")
	String quantity;
	
	@Transient
	MultipartFile productImage;
	

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", productImage=" + productImage + "]";
	}
	

}
