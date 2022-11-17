package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// The repo types are the type of object for the repo and its ID type
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  // "Student" here refers to the class, not the SQL table
  @Query("SELECT s FROM Student s WHERE s.email = ?1")
  Optional<Student> findStudentByEmail(String email);

}
