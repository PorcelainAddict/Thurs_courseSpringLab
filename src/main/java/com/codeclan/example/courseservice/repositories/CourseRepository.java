package com.codeclan.example.courseservice.repositories;

import com.codeclan.example.courseservice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course>findCourseByRating(Integer rating);

    List<Course>findCourseByBookingsCustomerNameIgnoreCase(String name);

}
