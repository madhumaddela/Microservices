package com.product.component.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.product.component.pojo.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query(value = "SELECT * FROM product product0_ WHERE product0_.product_category = ?1",nativeQuery = true)
	List<Product> productsByCategory(String category);
	
	

}
