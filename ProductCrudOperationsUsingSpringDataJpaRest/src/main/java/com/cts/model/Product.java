package com.cts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products_info")
@Data
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue
	private int productId;
	@NotBlank(message="Product name can't be empty")
	private String productName;
	@Min(value=100,message="Price must be greater than 99")
	private int productPrice;
	@Size(min=5,max=12,message="Category lenght must be between (5-12)")
	private String productCategory;
	@PositiveOrZero(message="No of products should not be negative")
	private int productQuantity;

	public Product(String productName, int productPrice, String productCategory, int productQuantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}

}
