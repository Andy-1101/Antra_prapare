package com.example.mvchomework.domin.DTO;

import com.example.mvchomework.domin.entity.Teacher;
import lombok.Data;

@Data
public class TeacherResponseDTO {
    private Integer teacher_id;
    private String teacher_name;
    private String course;

    public TeacherResponseDTO(Teacher teacher) {
        this.teacher_id = teacher.getTeacher_id();
        this.teacher_name = teacher.getTeacher_name();
        this.course = teacher.getCourse();
    }
}
