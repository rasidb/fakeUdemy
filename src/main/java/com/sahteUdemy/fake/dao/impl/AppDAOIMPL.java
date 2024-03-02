package com.sahteUdemy.fake.dao.impl;

import com.sahteUdemy.fake.dao.AppDAO;
import com.sahteUdemy.fake.entity.Course;
import com.sahteUdemy.fake.entity.Instructor;
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

    public AppDAOIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void createNewInstructorWithCourses(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    public Instructor findInstructorWithCourses(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i " +
                "JOIN FETCH i.courses " +
                "where i.id = :data", Instructor.class);
        query.setParameter("data",id);
        return query.getSingleResult();
    }

    @Override
    public List<Course> findCourses() {
        return entityManager.createQuery( "from Course", Course.class).getResultList();
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourse(int id) {
        return entityManager.find(Course.class,id);
    }
}
