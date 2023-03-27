package com.example.mvchomework.service;

import com.example.mvchomework.domin.DTO.TeacherResponseDTO;
import com.example.mvchomework.domin.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface TeacherService {
    Collection<TeacherResponseDTO> getAllTeacher();
}
