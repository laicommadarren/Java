package com.darrenlai.studentroster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.darrenlai.studentroster.models.Student;
import com.darrenlai.studentroster.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> allStudents() {
		return studentRepository.findAll();
	}
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student updateStudent(Student student) {
		return studentRepository.save(student);
		
	}
	
}
