package com.mongo.finalMongo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document
@Data
public class Student implements Serializable {
    @Id
    Integer studentId;
    String studentName;
    String studentDob;
    @DBRef
    List<Integer> courseIds = new ArrayList<>();
}
