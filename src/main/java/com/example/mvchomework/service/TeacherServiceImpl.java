package com.example.mvchomework.service;

import com.example.mvchomework.domin.DTO.TeacherResponseDTO;
import com.example.mvchomework.domin.entity.Teacher;
import com.example.mvchomework.exception.ResourceNotFoundException;
import com.example.mvchomework.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Collection<TeacherResponseDTO> getAllTeacher() {
        Collection<TeacherResponseDTO> res = teacherRepository
                .getAllTeacher()
                .stream()
                .map(TeacherResponseDTO::new)
                .collect(Collectors.toList());
        if(res.isEmpty()){
            throw new ResourceNotFoundException("No content!");
        }

        return res;
    }
}
