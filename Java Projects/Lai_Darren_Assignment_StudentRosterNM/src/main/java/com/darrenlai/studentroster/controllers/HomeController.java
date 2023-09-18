package com.darrenlai.studentroster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.darrenlai.studentroster.models.Dorm;
import com.darrenlai.studentroster.models.Student;
import com.darrenlai.studentroster.services.DormService;
import com.darrenlai.studentroster.services.StudentService;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class HomeController {
	@Autowired
	private DormService dormService;
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dorms";
	}
	@GetMapping("/dorms")
	public String dorms(Model model) {
		List<Dorm> dorms = dormService.allDorms();
		model.addAttribute("dorms", dorms);
		return "dorms.jsp";
	}
	@GetMapping("/dorms/new")
	public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
		return "newDorm.jsp";
	}
	@PostMapping("/dorms/new")
	public String addDorm(@ModelAttribute("dorm") Dorm dorm) {
		dormService.createDorm(dorm);
		return "redirect:/dorms";
	}
	@GetMapping("/students/new")
	public String newStudent(@ModelAttribute("student") Student student, Model model) {
		List<Dorm> dorms = dormService.allDorms();
		model.addAttribute("dorms", dorms);
		return "newStudent.jsp";
	}
	@PostMapping("/students/new")
	public String addStudent(@ModelAttribute("student") Student student) {
		studentService.createStudent(student);
		return "redirect:/dorms";
		}
	@GetMapping("/dorms/{id}")
	public String showDorm(@PathVariable("id") Long id, Model model) {
		Dorm dorm = dormService.findDorm(id);
		List<Student> students = studentService.allStudents();
		model.addAttribute("dorm", dorm);
		model.addAttribute("students", students);
		return "showDorm.jsp";
	}
	@PutMapping("/dorms/{id}/addStudent")
	public String addStudentToDojo(@ModelAttribute("student") Student student, Model model) {
		studentService.updateStudent(student);
		
		return "redirect:/dorms";
		}
}