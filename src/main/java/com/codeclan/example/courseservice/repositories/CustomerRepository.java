package com.codeclan.example.courseservice.repositories;

import com.codeclan.example.courseservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomerByBookingsCourseTitleIgnoreCase(String name);

    List<Customer> findCustomerByTownIgnoreCaseAndBookingsCourseTitleIgnoreCase(String town, String title);

    List<Customer> findCustomerByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseTitleIgnoreCase(Integer age, String town, String title);
}
