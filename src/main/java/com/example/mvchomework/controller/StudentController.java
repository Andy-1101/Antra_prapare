package com.example.mvchomework.controller;

import com.example.mvchomework.domin.DTO.StudentResponseDTO;
import com.example.mvchomework.domin.entity.Student;
import com.example.mvchomework.exception.ResourceNotFoundException;
import com.example.mvchomework.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<?> getAllStudent(){

        try {
            return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
        } catch (ResourceNotFoundException ex){
            return new ResponseEntity<>("No Content!", HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping("/{student_id}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer student_id){
        try {
            return new ResponseEntity<>(studentService.getStudentById(student_id), HttpStatus.OK);
        } catch (ResourceNotFoundException ex){
            return new ResponseEntity<>("Id not Found!", HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        try {
            return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
        } catch (RuntimeException ex ){
            return new ResponseEntity<>("createStudent() Failed!", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{student_id}/{student_name}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer student_id, @PathVariable String student_name){
        try {
            return new ResponseEntity<>(studentService.updateStudent(student_id, student_name), HttpStatus.ACCEPTED);
        }catch(ResourceNotFoundException ex ){
            return new ResponseEntity<>("Id Not Found!", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{student_id}/Teacher")
    public ResponseEntity<?> getAllTeacherById(@PathVariable Integer student_id){
        try {
            return new ResponseEntity<>(studentService.getAllTeacherById(student_id), HttpStatus.OK);
        } catch (RuntimeException ex){
            return new ResponseEntity<>("getAllTeacherById() Failed!", HttpStatus.BAD_REQUEST);

        }
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleException(){
        return new ResponseEntity<>(new ResourceNotFoundException("Something wrong with Student Controller")
                , HttpStatus.NOT_FOUND);

    }















}
