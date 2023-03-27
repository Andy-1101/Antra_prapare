package com.example.mvchomework.repository;

import com.example.mvchomework.MysqlConnection;
import com.example.mvchomework.domin.DTO.StudentResponseDTO;
import com.example.mvchomework.domin.entity.Student;
import com.example.mvchomework.domin.entity.Teacher;
import com.example.mvchomework.domin.entity.Teacher_Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Collection;
import java.util.stream.Collectors;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
    EntityManager conn = MysqlConnection.getInstance();
    @Override
    public Student getStudentById(Integer student_id) {
        return conn.find(Student.class, student_id);
    }

    @Override
    public Collection<Student> getAllStudent() {
        return  conn.createQuery("FROM Student").getResultList();
    }

    @Override
    public synchronized Integer createStudent(Student student) {

            EntityTransaction tx = conn.getTransaction();
            tx.begin();
            conn.merge(student);
            tx.commit();
            return null;

    }

    @Override
    public synchronized Integer updateStudent(Integer student_id, String student_name) {
        //Student student;
        Student student = conn.find(Student.class, student_id);
        student.setStudent_name(student_name);
        EntityTransaction tx = conn.getTransaction();
        tx.begin();
        conn.merge(student);
        tx.commit();

        return null;
    }

    @Override
    public Collection<Teacher> getAllTeacherById(Integer student_id) {
        return conn.find(Student.class, student_id)
                .getTeacher_student()
                .stream()
                .map(Teacher_Student::getTeacher_id).collect(Collectors.toList());
    }
}
