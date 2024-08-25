package com.mongo.finalMongo.repository;

import com.mongo.finalMongo.entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends MongoRepository<Course,Integer> { }
