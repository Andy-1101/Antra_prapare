package com.example.mvchomework.service;

import com.example.mvchomework.domin.DTO.StudentResponseDTO;
import com.example.mvchomework.domin.DTO.TeacherResponseDTO;
import com.example.mvchomework.domin.entity.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface StudentService {
    StudentResponseDTO getStudentById(Integer student_id);
    Collection<StudentResponseDTO> getAllStudent();
    Integer createStudent(Student student);

    Integer updateStudent(Integer student_id, String student_name);
    Collection<TeacherResponseDTO> getAllTeacherById(Integer student_id);
}
