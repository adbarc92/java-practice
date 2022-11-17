package com.example.demo.student;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> getStudents() {
    return studentService.getStudents();
  }

  // @PostMapping(value="path")
  // public SomeEnityData postMethodName(@RequestBody SomeEnityData entity) {
  // //TODO: process POST request

  // return entity;
  // }

  @PostMapping
  public Student registerNewStudent(@RequestBody Student student) {
    return studentService.addNewStudent(student);
  }

  @DeleteMapping(path = "{studentId}")
  public void deleteStudent(@PathVariable("studentId") Long id) {
    studentService.deleteStudent(id);
  }

}
