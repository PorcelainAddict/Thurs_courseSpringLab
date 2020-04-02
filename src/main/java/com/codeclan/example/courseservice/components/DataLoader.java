package com.codeclan.example.courseservice.components;

import com.codeclan.example.courseservice.models.Booking;
import com.codeclan.example.courseservice.models.Course;
import com.codeclan.example.courseservice.models.Customer;
import com.codeclan.example.courseservice.repositories.BookingRepository;
import com.codeclan.example.courseservice.repositories.CourseRepository;
import com.codeclan.example.courseservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component

public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        Customer customer1 = new Customer("Emma", "Linwood", 22);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Alan", "Cupar", 29);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Jack", "Cupar", 30);
        customerRepository.save(customer3);

        Course course1 = new Course("Intro into Ruby on Rails", "Glasgow", 5);
        courseRepository.save(course1);

        Course course2 = new Course("Intermediate Online Learning", "Glasgow", 4);
        courseRepository.save(course2);

        Course course3 = new Course("Bang Dynamics", "Glasgow", 5);
        courseRepository.save(course3);

        Course course4 = new Course("Intro into Banter", "Edinburgh", 5);
        courseRepository.save(course4);

        Booking booking1 = new Booking("01-01-2021", customer1, course1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("06-02-2021", customer2, course3);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("07-09-2025", customer1, course2);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("06-02-2021", customer3, course3);
        bookingRepository.save(booking4);

    }
}
