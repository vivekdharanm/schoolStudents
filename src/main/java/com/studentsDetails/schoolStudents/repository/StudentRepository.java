package com.studentsDetails.schoolStudents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentsDetails.schoolStudents.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{

}
