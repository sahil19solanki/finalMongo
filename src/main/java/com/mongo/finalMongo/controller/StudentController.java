package com.mongo.finalMongo.controller;

import com.mongo.finalMongo.dto.ApiResponse;
import com.mongo.finalMongo.dto.StudentDTO;
import com.mongo.finalMongo.service.StudentService;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @PostMapping("/register/{designation}")
    public ApiResponse<ResponseEntity<StudentDTO>> addOrUpdateStudent(
            @RequestBody StudentDTO studentDTO,
            @PathVariable String designation) {

        boolean isRegistered = studentService.addOrUpdateStudent(studentDTO, designation);

        if (isRegistered) {
            log.info("Student added successful");
            return ApiResponse.success(new ResponseEntity<>(studentDTO, HttpStatus.CREATED));
        } else {
            log.info("Student addition failed");
            return ApiResponse.failure("ADDITION_FAILED", "Failed to register student.");
        }
    }
    
    @DeleteMapping("/delete/{designation}/{studentId}")
    public  ApiResponse<ResponseEntity<Boolean>> deRegisterStudent(
            @PathVariable String designation,
            @PathVariable Integer studentId){
        boolean isDeregisterd = studentService.deleteStudent(designation,studentId);
        if (isDeregisterd) {
            log.info("delete successful");
            return ApiResponse.success(new ResponseEntity<>(true, HttpStatus.CREATED));
        } else {
            log.info("delete failed");
            return ApiResponse.failure("DELETION_FAILED", "Failed to delete student.");
        }
    }
}
