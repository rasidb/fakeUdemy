package com.sahteUdemy.fake;

import com.github.javafaker.Faker;
import com.sahteUdemy.fake.dao.AppDAO;
import com.sahteUdemy.fake.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class FakeApplication {
    @Autowired
    AppDAO appDAO;

    public FakeApplication(AppDAO appDAO) {
        this.appDAO = appDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(FakeApplication.class, args);
    }

    @Bean
    public CommandLineRunner myRunner() {
        return runner -> {
 //createNewInstructorWithCourses(appDAO);
        };
    }

    private void updateCourse(AppDAO appDAO) {
        //Course course = appDAO.findCourse(10);
       // course.setTitle("at egitmenligi");
      //  appDAO.update(course);

       Course course = appDAO.findCourse(11);
        course.setTitle("patates nasil soyulur");
        appDAO.update(course);
        course = appDAO.findCourse(12);
        course.setTitle("adam dolandirma");
         appDAO.update(course);
    }

    private void addNewCourseToInstructorByInstructorId(AppDAO appDAO) {
      Instructor instructor=  appDAO.findInstructorWithCourses(1);
      instructor.add(new Course("new course"));
      appDAO.save(instructor);
    }

    private void createNewInstructorWithCourses(AppDAO appDAO) {
      Instructor instructor;
      InstructorDetail instructorDetail;
      String firsname;
      String lastName;
      String email;
      Faker faker =new Faker();
        for (int i = 0; i <50; i++) {
        firsname=faker.funnyName().name();
        lastName=faker.name().lastName();
        email=faker.name().username();
        instructor=new Instructor(firsname,lastName,email);
        instructorDetail=new InstructorDetail(faker.animal().name(),faker.howIMetYourMother().highFive());
        instructor.setInstructorDetail(instructorDetail);

        instructor.add(new Course(faker.name().title()));
        instructor.add(new Course(faker.name().title()));
        instructor.add(new Course(faker.name().title()));
        appDAO.save(instructor);
        }
    }

}
