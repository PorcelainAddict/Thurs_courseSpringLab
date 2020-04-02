package com.codeclan.example.courseservice.controllers;

import com.codeclan.example.courseservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity getCustomers(
            @RequestParam(name = "course", required = false) String title,
            @RequestParam(name = "town", required = false) String town,
            @RequestParam(name = "ageGreater", required = false) Integer age
    ){
        if(title != null && town == null && age == null){
            return new ResponseEntity(customerRepository.findCustomerByBookingsCourseTitleIgnoreCase(title), HttpStatus.OK);
        }
        if(title != null && town != null && age == null){
            return new ResponseEntity(customerRepository.findCustomerByTownIgnoreCaseAndBookingsCourseTitleIgnoreCase(town, title), HttpStatus.OK);
        }
        if(title != null && age != null && town != null){
            return new ResponseEntity(customerRepository.findCustomerByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseTitleIgnoreCase(age, town, title), HttpStatus.OK);
        }
        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }
}


//Get all customers for a given course
//Get all customers in a given town for a given course
//Get all customers over a certain age in a given town for a given course