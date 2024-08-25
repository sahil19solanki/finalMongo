package com.mongo.finalMongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
public class Course {
    @Id
    Integer courseId;
    String courseName;
    Integer courseFee;
    @DBRef
    List<Student> studentIds = new ArrayList<>();
}
