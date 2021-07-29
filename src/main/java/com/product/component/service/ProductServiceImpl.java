package com.product.component.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.component.pojo.Product;
import com.product.component.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository repo;

	public Product createProduct(Product product) {
		return repo.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		return repo.productsByCategory(category);
	}

	@Override
	public Product getProductById(long id) {
		Optional<Product> product = repo.findById(id);
		Product existingProduct = new Product();
		if (product.isPresent()) {
			existingProduct.setProduct_Id(product.get().getProduct_Id());
			existingProduct.setProduct_Name(product.get().getProduct_Name());
			existingProduct.setProduct_Category(product.get().getProduct_Category());
			existingProduct.setProduct_Price(product.get().getProduct_Price());
		}
		return existingProduct;
	}

}
