package com.product.component.service;

import java.util.List;

import com.product.component.pojo.Product;

public interface ProductService {

	public Product createProduct(Product product);

	public List<Product> getAllProducts();

	public List<Product> getProductByCategory(String category);

	public Product getProductById(long id);

}
