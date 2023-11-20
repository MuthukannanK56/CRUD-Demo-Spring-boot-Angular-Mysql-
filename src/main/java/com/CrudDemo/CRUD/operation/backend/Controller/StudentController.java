package com.CrudDemo.CRUD.operation.backend.Controller;

import com.CrudDemo.CRUD.operation.backend.Model.*;
import com.CrudDemo.CRUD.operation.backend.Repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return studentRepository.findAll();

    }
}
