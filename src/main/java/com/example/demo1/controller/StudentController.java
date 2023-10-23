package com.example.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo1.entity.Student;
import com.example.demo1.repository.StudentRepository;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/save")
    public void save(@RequestBody Student student) {
        studentRepository.save(student);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        studentRepository.deleteById(id);
    }

    @GetMapping("/all")
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/count")
    public long countStudents() {
        return studentRepository.count();
    }

    @GetMapping("/byYear")
    public Collection<?> findByYear() {
        return studentRepository.findNbrStudentByYear();
    }
}
