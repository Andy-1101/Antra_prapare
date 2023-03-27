package com.example.mvchomework.domin.entity;

import com.example.mvchomework.domin.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Teacher_Student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher_Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ts_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher_id;

    @Override
    public String toString() {
        return "Teacher_Student{" +
                "id='" + ts_id + '\'' +
                ",student_id='" + student_id + '\'' +
                ",teacher_id='" + teacher_id +'\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher_Student that = (Teacher_Student) o;
        return Objects.equals(ts_id, that.ts_id) && Objects.equals(student_id, that.student_id) && Objects.equals(teacher_id, that.teacher_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ts_id, student_id, teacher_id);
    }
}