package com.example.mvchomework.service;


import com.example.mvchomework.domin.DTO.StudentResponseDTO;
import com.example.mvchomework.domin.DTO.TeacherResponseDTO;
import com.example.mvchomework.domin.entity.Student;
import com.example.mvchomework.exception.ResourceNotFoundException;
import com.example.mvchomework.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponseDTO getStudentById(Integer student_id) {
        try {
            return new StudentResponseDTO(studentRepository.getStudentById(student_id));
        } catch(RuntimeException ex){
            throw new ResourceNotFoundException("Id Not Found!");
        }
    }

    @Override
    public Collection<StudentResponseDTO> getAllStudent() {

        Collection<StudentResponseDTO> res = studentRepository
                .getAllStudent()
                .stream()
                .map(e -> new StudentResponseDTO(e))
                .collect(Collectors.toList());
        if(res.isEmpty()){
            throw new ResourceNotFoundException("No Content");
        }
        return res;
    }

    @Override
    public Integer createStudent(Student student) {
        return studentRepository.createStudent(student);
    }

    @Override
    public Integer updateStudent(Integer student_id, String student_name) {

        try {
            return studentRepository.updateStudent(student_id, student_name);
        } catch (RuntimeException ex){
            throw new ResourceNotFoundException("Student Id not found!");
        }


    }

    @Override
    public Collection<TeacherResponseDTO> getAllTeacherById(Integer student_id) {
        return studentRepository.getAllTeacherById(student_id)
                .stream()
                .map(e -> new TeacherResponseDTO(e))
                .collect(Collectors.toList());
    }
}
