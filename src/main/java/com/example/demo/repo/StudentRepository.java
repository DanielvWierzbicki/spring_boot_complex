package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.name = ?1 or s.email = ?1")
    Optional<Student> findStudentByNameOrEmail(String name, String email);

    @Query("SELECT s FROM Student s WHERE s.id = ?1")
    Student findStudentById(long id);

}
