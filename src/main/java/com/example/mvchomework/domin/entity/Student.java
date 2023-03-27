package com.example.mvchomework.domin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Table(name="Student")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;

    @Column(name = "student_name")
    private String student_name;

    @OneToMany(mappedBy="student_id", fetch=FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Teacher_Student> teacher_student;


    public Student(Integer student_id, String student_name){
        this.student_id = student_id;
        this.student_name = student_name;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id='" + student_id + '\'' +
                ", name='" + student_name + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(student_id, student.student_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id);
    }
}
