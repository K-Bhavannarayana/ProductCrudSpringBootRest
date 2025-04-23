package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.ProductNotFound;
import com.cts.model.Product;
import com.cts.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	//@RequestMapping(value="/getMsg",method=RequestMethod.GET)
	@GetMapping("/getMsg")
	public String sayHello() {
		return "i will leave by 11 am today";
	}
	
	@PostMapping("/saveProduct") // http://localhost:1112/products/saveProduct
	public String insertProduct(@RequestBody @Validated Product product) {
		return service.addProduct(product);
		}
	
	@PutMapping("/updateProduct") // http://localhost:1112/products/updateProduct
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@GetMapping("/getProduct/{pid}") // http://localhost:1112/products/getProduct/1
	public Product viewProduct(@PathVariable("pid") int productId) throws ProductNotFound {
		return service.viewProduct(productId);
	}
	
	@GetMapping("/removeProduct/{pid}") // http://localhost:1112/products/removeProduct/1
	public String removeProduct(@PathVariable("pid") int productId) {
		return service.removeProduct(productId);
	}
	
	@GetMapping("/getAllProducts") // http://localhost:1112/products/getAllProduct
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}
	
	@GetMapping("/getAllProductsBetween/{price1}/{price2}") // http://localhost:1112/products/getAllProductBetween/10000/50000
	public List<Product> getAllProductsBetween(@PathVariable("price1") int price1,@PathVariable("price2") int price2) {
		return service.getAllProductsBetween(price1,price2);
	}
	
	@GetMapping("/getallproductsbycategory/{category}") // http://localhost:1112/products/getallproductsbycategory/vehicle
	public List<Product> getAllProductByCategory(@PathVariable("category") String category) {
		return service.getAllProductsByCategory(category);
	}
}
