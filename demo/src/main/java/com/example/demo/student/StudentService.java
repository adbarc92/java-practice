package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  public Student saveStudent(Student student) {
    Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
    if (studentOptional.isPresent()) {
      // TODO: write custom exceptions
      throw new IllegalStateException("email taken");
    } else {
      return studentRepository.save(student);
    }
  }

  // TODO: make this return the deleted student
  public void deleteStudent(long studentId) {
    if (studentRepository.existsById(studentId)) {
      studentRepository.deleteById(studentId);
    } else {
      throw new IllegalStateException("Student with id " + studentId + " not exist");
    }
  }

  @Transactional
  public Student updateStudent(long studentId, Student fixedStudent) {
    Optional<Student> studentExists = studentRepository.findById(studentId);
    if (studentExists.isPresent()) {
      Student student = studentExists.get();
      student.setName(fixedStudent.getName());
      // Validation: throw exception if email is taken.
      student.setEmail(fixedStudent.getEmail());
      student.setDob(fixedStudent.getDob());
      return studentRepository.save(student);
    } else {
      throw new IllegalStateException("Student with id " + studentId + " not exist");
    }
  }
}
