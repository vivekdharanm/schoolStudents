package com.studentsDetails.schoolStudents.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.studentsDetails.schoolStudents.model.Student;
import com.studentsDetails.schoolStudents.service.StudentService;

public class StudentController 
{
	public final StudentService studentService;
	
	public StudentController(StudentService studentService)
	{
		this.studentService=studentService;
	}
	
	@GetMapping
	public List<Student> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	@GetMapping
	public ResponseEntity<Student> getStudentById(@PathVariable Long id)
	{
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
	}
    
	@PostMapping
    public Student createStudent(@RequestBody Student student) 
    {
            return studentService.createStudent(student);
    }
    
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id)
    {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
            
            

