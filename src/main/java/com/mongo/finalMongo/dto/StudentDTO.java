package com.mongo.finalMongo.dto;

import com.mongo.finalMongo.entity.Student;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StudentDTO{
    Integer studentId;
    String studentName;
    String studentDob;
    List<Student> courseIds = new ArrayList<>();

}
