package com.codeclan.example.courseservice.controllers;

import com.codeclan.example.courseservice.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping
    public ResponseEntity getCourses(
            @RequestParam(name = "rating", required = false) Integer rating,
            @RequestParam(name = "customer", required = false) String name
    ){
        if(rating != null){
            return new ResponseEntity(courseRepository.findCourseByRating(rating), HttpStatus.OK);
        }
        if (name != null){
            return new ResponseEntity(courseRepository.findCourseByBookingsCustomerNameIgnoreCase(name), HttpStatus.OK);
        }
        return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);
    }
}
