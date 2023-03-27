package com.example.mvchomework.domin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.List;
import java.util.*;

@Entity
@Table(name="Teacher")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacher_id;

    @Column(name="teacher_name")
    private String teacher_name;

    @Column(name = "course")
    private String course;

    @OneToMany(mappedBy = "teacher_id", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<Teacher_Student> teacher_student;

    public Teacher(Integer teacher_id, String teacher_name, String course) {
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.course = course;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id='" + teacher_id + '\'' +
                ", name='" + teacher_name + '\'' +
                ",course='" + course + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(teacher_id, teacher.teacher_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacher_id);
    }
}

