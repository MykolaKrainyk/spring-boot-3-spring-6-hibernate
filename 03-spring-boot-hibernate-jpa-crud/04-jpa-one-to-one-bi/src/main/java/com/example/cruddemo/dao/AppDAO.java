package com.example.cruddemo.dao;

import com.example.cruddemo.entity.Instructor;
import com.example.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save (Instructor instructor);

    Instructor findInstructorById(int instructorId);

    InstructorDetail findInstructorDetailById(int instructorDetailId);
}
