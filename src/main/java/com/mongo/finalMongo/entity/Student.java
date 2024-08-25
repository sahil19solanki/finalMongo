package com.mongo.finalMongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
@Data
public class Student implements Serializable {
    @Id
    Integer studentId;
    String studentName;
    String studentDob;
    Integer courseId;
}
