package com.cts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

	public abstract List<Product> findByProductPriceBetween(int minPrice, int maxPrice);

	public abstract List<Product> findByProductCategory(String category);
	
	public abstract List<Product> findByProductPriceGreaterThan(int minPrice);
	
}
