package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.entity.Student;
import com.example.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents( Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm( Model model) {
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student)
    {
        studentService.save(student);

        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student",studentService.getStundentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,  @ModelAttribute("student") Student student, Model model)
    {
        Student exStudent = studentService.getStundentById(id);
        exStudent.setFirstName(student.getFirstName());
        exStudent.setLastName(student.getLastName());
        exStudent.setEmail(student.getEmail());
        exStudent.setId(id);

        studentService.updateStudent(exStudent);
        return "redirect:/students";
    }
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id, Model model)
    {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
