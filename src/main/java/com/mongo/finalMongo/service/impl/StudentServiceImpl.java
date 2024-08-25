package com.mongo.finalMongo.service.impl;

import com.mongo.finalMongo.constants.UserType;
import com.mongo.finalMongo.dto.StudentDTO;
import com.mongo.finalMongo.entity.Student;
import com.mongo.finalMongo.repository.StudentRepository;
import com.mongo.finalMongo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public boolean addOrUpdateStudent(StudentDTO studentDTO, String designation) {
        String s = UserType.INSTRUCTOR.toString().toLowerCase(Locale.ROOT);
        if (UserType.INSTRUCTOR.toString().toLowerCase().equals(designation)) {
            Student student = new Student();
            BeanUtils.copyProperties(studentDTO, student);
            try {
                studentRepository.save(student);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean deleteStudent(String designation,Integer studentDTOId) {
        if (UserType.INSTRUCTOR.toString().toLowerCase().equals(designation)) {
            try {
                studentRepository.deleteById(studentDTOId);
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
