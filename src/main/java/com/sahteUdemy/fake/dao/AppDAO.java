package com.sahteUdemy.fake.dao;

import com.sahteUdemy.fake.entity.Course;
import com.sahteUdemy.fake.entity.Student;

import java.util.List;

public interface AppDAO {

    List<Course> findCourses();

    Course findCourse(int kursId);
    void save(Student student);
    void addNewCourseToStudent(Student student);

    Student findStudentByIdJoinFetch(int id);
    Student findStudentById(int id);
}
