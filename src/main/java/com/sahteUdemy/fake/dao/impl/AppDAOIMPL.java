package com.sahteUdemy.fake.dao.impl;

import com.sahteUdemy.fake.dao.AppDAO;
import com.sahteUdemy.fake.entity.Course;
import com.sahteUdemy.fake.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class AppDAOIMPL implements AppDAO {
    @Autowired
   private EntityManager entityManager;

    public AppDAOIMPL (EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Course> findCourses() {
      return   entityManager.createQuery(" from Course ", Course.class).getResultList();
    }

    @Override
    public Course findCourse(int kursId) {
        return entityManager.find(Course.class,kursId);
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void addNewCourseToStudent(Student student) {
    entityManager.merge(student);
    }

    @Override
    public Student findStudentByIdJoinFetch(int id) {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s " +
                "JOIN FETCH s.courses " +
                "where s.id = :data ", Student.class);
        query.setParameter("data",id);
        return query.getSingleResult();
    }

    @Override
    public Student findStudentById(int id) {
        return entityManager.find(Student.class,id);
    }


}
