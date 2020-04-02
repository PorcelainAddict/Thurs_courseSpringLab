package com.codeclan.example.courseservice;

import com.codeclan.example.courseservice.models.Booking;
import com.codeclan.example.courseservice.models.Course;
import com.codeclan.example.courseservice.models.Customer;
import com.codeclan.example.courseservice.repositories.BookingRepository;
import com.codeclan.example.courseservice.repositories.CourseRepository;
import com.codeclan.example.courseservice.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseserviceApplicationTests {


	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindCourseOfFiveRating(){
		List<Course> foundCourses = courseRepository.findCourseByRating(5);
	}

	@Test
	public void canFindCustomerByCourseTitle(){
		List<Customer> foundCustomer = customerRepository.findCustomerByBookingsCourseTitleIgnoreCase("Bang Dynamics");
	}

	@Test
	public void canFindCourseByCustomerName(){
		List<Course> foundCourse = courseRepository.findCourseByBookingsCustomerNameIgnoreCase("Emma");
	}

	@Test
	public void canFindBookingByBookingDate(){
		List<Booking> foundBookings = bookingRepository.findBookingByDate("01-01-2021");
	}

	@Test
	public void canFindCustomerByBookingsCourseTown(){
		List<Customer> foundCustomer = customerRepository.findCustomerByTownIgnoreCaseAndBookingsCourseTitleIgnoreCase("Cupar", "Bang Dynamics");
	}

	@Test
	public void canFindCustomerByAgeGreaterThan_29(){
		List<Customer> foundCustomer = customerRepository.findCustomerByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseTitleIgnoreCase(29, "Cupar", "Bang Dynamics");
	}



}
