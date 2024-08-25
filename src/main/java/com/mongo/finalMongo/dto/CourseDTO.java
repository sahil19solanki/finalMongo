package com.mongo.finalMongo.dto;

import com.mongo.finalMongo.entity.Student;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CourseDTO {
    Integer courseId;
    String courseName;
    Integer courseFee;
    List<Student> studentIds = new ArrayList<>();
}
