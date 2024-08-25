package com.mongo.finalMongo.service;

import com.mongo.finalMongo.dto.StudentDTO;

public interface StudentService {
    public boolean addOrUpdateStudent(StudentDTO studentDTO, String designation);
    public boolean deleteStudent(String designation,Integer studentDTOId);
}
