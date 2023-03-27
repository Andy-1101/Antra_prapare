package com.example.mvchomework.repository;

import com.example.mvchomework.domin.DTO.StudentResponseDTO;
import com.example.mvchomework.domin.entity.Student;
import com.example.mvchomework.domin.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StudentRepository {
    Student getStudentById(Integer student_id);
    Collection<Student> getAllStudent();
    Integer createStudent(Student student);

    Integer updateStudent(Integer student_id, String student_name);
    Collection<Teacher> getAllTeacherById(Integer student_id);
}
