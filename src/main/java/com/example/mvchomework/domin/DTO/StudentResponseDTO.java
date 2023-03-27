package com.example.mvchomework.domin.DTO;

import com.example.mvchomework.domin.entity.Student;
import lombok.Data;

@Data
public class StudentResponseDTO {
    private Integer student_id;
    private String student_name;

    public StudentResponseDTO(Student student) {
        this.student_id = student.getStudent_id();
        this.student_name = student.getStudent_name();
    }



}
