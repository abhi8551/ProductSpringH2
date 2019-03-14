package com.springH2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springH2.entities.Product;
import com.springH2.services.ProductService;

@RestController
@RequestMapping("/api/")
public class ProductController {
	
	@Autowired
	ProductService productService;


    @GetMapping("/products")
    private List<Product> getAllPersons() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    private Product getPerson(@PathVariable("id") int id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/products/{id}")
    private void deletePerson(@PathVariable("id") Long id) {
    	productService.delete(id);
    }

    @PostMapping("/products")
    private Long savePerson(@RequestBody Product product) {
    	productService.saveOrUpdate(product);
        return product.getId();
    }
}
