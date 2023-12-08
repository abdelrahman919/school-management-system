package com.abdelrahman.schoolmanagementsystem.service;

import com.abdelrahman.schoolmanagementsystem.dto.teacher.TeacherDto;
import com.abdelrahman.schoolmanagementsystem.dto.teacher.TeacherRegisterDTO;
import com.abdelrahman.schoolmanagementsystem.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    Teacher createTeacher(TeacherRegisterDTO teacher);

    List<Teacher> getAllTeacher();

    Teacher getTeacherById(Long id);

    void updateTeacher(Long id, Teacher updatedTeacher);

    void addTeachersToClass(Long cId, List<Long> ids);

    List<TeacherDto> getAllTeacherDTO();

    TeacherDto getTeacherDtoById(Long id);
}
