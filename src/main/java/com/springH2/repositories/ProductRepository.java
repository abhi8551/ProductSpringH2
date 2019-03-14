package com.springH2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springH2.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	Product findById(int id);
}
