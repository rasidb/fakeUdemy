package com.sahteUdemy.fake.dao;

import com.sahteUdemy.fake.entity.Course;
import com.sahteUdemy.fake.entity.Instructor;
import com.sahteUdemy.fake.entity.Student;

import java.util.List;

public interface AppDAO {
void createNewInstructorWithCourses(Instructor instructor);

    void save(Instructor instructor);

    Instructor findInstructorWithCourses(int id);

    List<Course> findCourses();

   void update(Course course);

    Course findCourse(int id);
}
