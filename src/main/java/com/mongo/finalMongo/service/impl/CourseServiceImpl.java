package com.mongo.finalMongo.service.impl;

import com.mongo.finalMongo.constants.UserType;
import com.mongo.finalMongo.dto.CourseDTO;
import com.mongo.finalMongo.entity.Course;
import com.mongo.finalMongo.entity.Student;
import com.mongo.finalMongo.repository.CourseRepository;
import com.mongo.finalMongo.service.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Override
    public boolean addOrUpdateCourse(CourseDTO courseDTO, String designation) {
        if (UserType.INSTRUCTOR.toString().toLowerCase().equals(designation)) {
            Course course = new Course();
            BeanUtils.copyProperties(courseDTO, course);
            try {
                courseRepository.save(course);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean deleteCourse(String designation, Integer courseDTOId) {
        if (UserType.INSTRUCTOR.toString().toLowerCase().equals(designation)) {
            try {
                courseRepository.deleteById(courseDTOId);
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
