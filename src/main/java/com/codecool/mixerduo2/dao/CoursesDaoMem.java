package com.codecool.mixerduo2.dao;

import com.codecool.mixerduo2.model.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CoursesDaoMem {

    private List<Course> courses = new ArrayList<>();

    public CoursesDaoMem() {
        Course course1 = new Course("Pro",80 );
        Course course2 = new Course("Advanced", 50);
        Course course3 = new Course("Beginners", 30);
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
    }

    public List<Course> getCourses() {
        return courses;
    }
}
