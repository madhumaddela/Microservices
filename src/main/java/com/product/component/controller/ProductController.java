package com.product.component.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.component.pojo.Product;
import com.product.component.service.ProductService;

@RestController
@RequestMapping(value = "/product-service")
public class ProductController {

	@Autowired
	public ProductService service;

	@PostMapping(value = "/create-product")
	public Product createProduct(@RequestBody Product product) {
		return service.createProduct(product);
	}

	@GetMapping(value = "/allProducts")
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}
	
	@GetMapping("/products-by-category/{category}")
	public List<Product> findByCategory(@PathVariable("category") String category) {
		return service.getProductByCategory(category);

	}

	@GetMapping("/product-by-id/{id}")
	public Product findById(@PathVariable("id") long id) {
		return service.getProductById(id);
	}

}
