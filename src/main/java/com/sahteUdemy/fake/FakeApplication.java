package com.sahteUdemy.fake;

import com.sahteUdemy.fake.dao.AppDAO;
import com.sahteUdemy.fake.entity.Course;
import com.sahteUdemy.fake.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
        return args -> {
        addCourseToStudent(appDAO);
        };
    }

    private void addCourseToStudent(AppDAO appDAO) {
        Student student = appDAO.findStudentByIdJoinFetch(1);
        student.add(new Course("patates soyma"));
        student.add(new Course("patates haslama"));
        student.add(new Course("patates tuzlama"));
        appDAO.save(student);
    }

    private void addNewStudent(AppDAO appDAO) {
        Student student =new Student("ilk ögrenci","bu da soyadi","mail","student");
        appDAO.save(student);
    }
}
