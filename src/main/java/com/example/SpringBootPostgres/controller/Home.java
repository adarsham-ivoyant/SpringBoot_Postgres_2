package com.example.SpringBootPostgres.controller;

import com.example.SpringBootPostgres.entity.Course;
import com.example.SpringBootPostgres.entity.Student;
import com.example.SpringBootPostgres.repository.CourseRepo;
import com.example.SpringBootPostgres.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("home/")
public class Home {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CourseRepo courseRepo;

    //course
    @PostMapping("addCourse/")
    public String addCourse(@RequestBody Course course){
        courseRepo.save(course);
        return "Course Added Successfully";
    }

    @GetMapping("getCourseById/{id}")
    public Course getCourseById(@PathVariable("id") int id){
        return courseRepo.findById(id).get();
    }

    @GetMapping("getAllCourse")
    public List<Course> getAllCourse(){
        return courseRepo.findAll();
    }
    @DeleteMapping("deleteCourseById/{id}")
    public String deleteCourseById(@PathVariable("id") int id){
        courseRepo.deleteById(id);
        return "deleted successfully";
    }

    @PostMapping("add/")
    public String add(@RequestBody Student student){
        studentRepo.save(student);
        return "added";
    }

    @GetMapping("getStudentById/{id}")
    public Student getStudentById(@PathVariable("id") int id){
        return studentRepo.findById(id).get();
    }

    @DeleteMapping("deleteStudentById/{id}")
    public String deleteStudentById(@PathVariable("id") int id){
        courseRepo.deleteById(id);
        return "Deleted Successfully";
    }

    @GetMapping("getAllStudent")
    public List<Student> getAllStudent(){
        return studentRepo.findAll();
    }



}
