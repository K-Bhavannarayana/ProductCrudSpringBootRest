package com.cts.service;

import java.util.List;

import com.cts.exception.ProductNotFound;
import com.cts.model.Product;

public interface ProductService {
	public abstract String addProduct(Product product);

	public abstract String removeProduct(int productId);

	public abstract Product updateProduct(Product product);

	public abstract Product viewProduct(int productId) throws ProductNotFound ;

	public abstract List<Product> getAllProducts();

	public abstract List<Product> getAllProductsBetween(int minPrice, int maxPrice);

	public abstract List<Product> getAllProductsByCategory(String category);
	
	public abstract List<Product> getAllProductsGreaterThanPrice(int minPrice);

}
