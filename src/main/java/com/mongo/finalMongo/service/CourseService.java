package com.mongo.finalMongo.service;

import com.mongo.finalMongo.dto.CourseDTO;
import com.mongo.finalMongo.dto.StudentDTO;
import org.springframework.stereotype.Service;


public interface CourseService {
    public boolean addOrUpdateCourse(CourseDTO courseDTO, String designation);
    public boolean deleteCourse(String designation,Integer courseDTOId);
}
