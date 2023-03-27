package com.example.mvchomework;

import com.example.mvchomework.domin.entity.Student;
import com.example.mvchomework.domin.entity.Teacher;
import com.example.mvchomework.domin.entity.Teacher_Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootApplication
public class MvcHomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcHomeworkApplication.class, args);


    }



}
