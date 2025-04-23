package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.exception.ProductNotFound;
import com.cts.model.Product;
import com.cts.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductRepository repository;

	@Override
	public String addProduct(Product product) {
		log.info("In productServiceImpl saveproduct method");
		Product pro = repository.save(product);
		if (pro != null)
			return "Product saved successfully";
		return "Error saving the product";
	}

	@Override
	public String removeProduct(int productId) {
		repository.deleteById(productId);
		return "product removed";
	}

	@Override
	public Product updateProduct(Product product) {
		Product pro = repository.save(product);
		return pro;
	}

	@Override
	public Product viewProduct(int productId)throws ProductNotFound{
		Optional<Product> optional = repository.findById(productId);
		if(optional.isPresent())
			return optional.get();
		else
			throw new ProductNotFound("No Product found with that product Id");
	}

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public List<Product> getAllProductsBetween(int minPrice, int maxPrice) {
		return repository.findByProductPriceBetween(minPrice, maxPrice);
	}

	@Override
	public List<Product> getAllProductsByCategory(String category) {
		return repository.findByProductCategory(category);
	}

	@Override
	public List<Product> getAllProductsGreaterThanPrice(int minPrice) {
		return repository.findByProductPriceGreaterThan(minPrice);
	}

}
