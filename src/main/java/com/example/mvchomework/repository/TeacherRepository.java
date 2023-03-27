package com.example.mvchomework.repository;
import com.example.mvchomework.domin.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TeacherRepository {
    Collection<Teacher> getAllTeacher();
}
