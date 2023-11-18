 package com.http.methods.controller;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.http.methods.dto.Product;
import com.http.methods.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	public ProductService service;
	
	@PostMapping("/create-product")
public String createProduct(@RequestBody Product prod) {
		service.saveProduct(prod);
	return  " product Successfully created";
}   
	@GetMapping("/get-product")
	public List<Product> getProduct(){
		return service.getProduct();	
	}
	 //update product
	@PutMapping("/update-product")
	public String UpdateProduct(@RequestBody Product prod) {
		service.updateProduct(prod);
		return "Product Updated Successfully";
		
	}
	@DeleteMapping("/delete-product/{id}")
	public String deleteProduct(@PathVariable(name="id")int id) {
		service.deleteProduct(id);
		return "Product deleted Successfully";
		
	}
		 
	
}
