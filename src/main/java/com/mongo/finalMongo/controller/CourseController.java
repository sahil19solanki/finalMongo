package com.mongo.finalMongo.controller;

import com.mongo.finalMongo.dto.ApiResponse;
import com.mongo.finalMongo.dto.CourseDTO;
import com.mongo.finalMongo.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;
    private static final Logger log = LoggerFactory.getLogger(CourseController.class);

    @PostMapping("/register/{designation}")
    public ApiResponse<ResponseEntity<CourseDTO>> addOrUpdateCourse(
            @RequestBody CourseDTO courseDTO,
            @PathVariable String designation) {

        boolean isRegistered = courseService.addOrUpdateCourse(courseDTO, designation);

        if (isRegistered) {
            log.info("course added successfully");
            return ApiResponse.success(new ResponseEntity<>(courseDTO, HttpStatus.CREATED));
        } else {
            log.info("course addition failed");
            return ApiResponse.failure("ADDITION_FAILED", "Failed to register course.");
        }
    }

    @DeleteMapping("/delete/{designation}/{studentId}")
    public  ApiResponse<ResponseEntity<Boolean>> deRegisterCourse(
            @PathVariable String designation,
            @PathVariable Integer courseId){
        boolean isDeregistered = courseService.deleteCourse(designation,courseId);
        if (isDeregistered) {
            log.info("Course deleted successfully");
            return ApiResponse.success(new ResponseEntity<>(true, HttpStatus.CREATED));
        } else {
            log.info("Course delete failed");
            return ApiResponse.failure("DELETION_FAILED", "Failed to delete course.");
        }
    }
}
