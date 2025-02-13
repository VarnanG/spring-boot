package com.example.demo;

import java.util.List;

//Provides basic CRUD (Create, Read, Update, Delete) operations.
import org.springframework.data.repository.CrudRepository;

//CustomerRepository is an interface extending CrudRepository<Customer, Long>.
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	  List<Customer> findByLastName(String lastName);

	  Customer findById(long id);
	}
