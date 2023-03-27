package com.example.mvchomework.repository;

import com.example.mvchomework.MysqlConnection;
import com.example.mvchomework.domin.entity.Teacher;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository{
    EntityManager conn = MysqlConnection.getInstance();
    @Override
    public Collection<Teacher> getAllTeacher() {
        return conn.createQuery("FROM Teacher").getResultList();
    }
}
