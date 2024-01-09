package com.CrudDemo.CRUD.operation.backend.Controller;

import com.CrudDemo.CRUD.operation.backend.Exception.*;
import com.CrudDemo.CRUD.operation.backend.Model.*;
import com.CrudDemo.CRUD.operation.backend.Repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    //Get all student list
    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }


    //Add Student details
    @PostMapping("/addstudent")
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    //Get Student By ID
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentbyid(@PathVariable Long id){
        Student student= studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with this id"+id));
        return ResponseEntity.ok(student);
    }

    //Update Student By Id
    @PutMapping("/updatestudent/{id}")
    public ResponseEntity<Student> updateEmployee(@PathVariable Long id, @RequestBody Student studentDetails){
        //studentDetails  is object it is input from user for update

        //Student model object -> student
        Student student = studentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not found with this id"+id));
        //student-> model object
        //studentDetails -> input from user
        // set the new data(studentDetails.getName()) to table (student.setName)
        student.setName(studentDetails.getName());
        student.setMobilenumber(studentDetails.getMobilenumber());
        student.setAddress(studentDetails.getAddress());
        student.setEmail(studentDetails.getEmail());

        Student updatedstudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedstudent);

    }


    //Delete student details by id
    @DeleteMapping("/deletestudent/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteStudent(@PathVariable Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not found with this id"+id));
        studentRepository.delete(student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }




}
