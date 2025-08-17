package com.example.__JPA_Demo.controllers;


import com.example.__JPA_Demo.entity.Student;
import com.example.__JPA_Demo.repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

//    @Autowired
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentRepository.save(student));
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @PutMapping
    public Student updateStudent(@RequestParam Long id,@RequestBody Student student){
        Student s = studentRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Student not found"));

        s.setName(student.getName());
        s.setEmail(student.getEmail());

        return studentRepository.save(s);
    }
}
