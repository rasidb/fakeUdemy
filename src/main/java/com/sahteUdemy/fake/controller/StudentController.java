package com.sahteUdemy.fake.controller;

import com.sahteUdemy.fake.dao.AppDAO;
import com.sahteUdemy.fake.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class StudentController {

    @Autowired
    private AppDAO appDAO;

    public StudentController(AppDAO appDAO) {
        this.appDAO = appDAO;
    }

    @GetMapping("/mainpage")
    public String mainPage(Model model) {
        List<Course> courses = appDAO.findCourses();
        model.addAttribute("courses", courses);
        return "mainpage";
    }

    @GetMapping("/kursaGit")
    public String kursuGöster(@RequestParam int kursId,Model model){
        Course course = appDAO.findCourse(kursId);
        model.addAttribute("course",course);
        return "kurs";
    }
}
