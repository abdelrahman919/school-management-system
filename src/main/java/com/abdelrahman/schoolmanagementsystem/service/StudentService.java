package com.abdelrahman.schoolmanagementsystem.service;

import com.abdelrahman.schoolmanagementsystem.dto.StudentDto;
import com.abdelrahman.schoolmanagementsystem.dto.StudentRegisterDTO;
import com.abdelrahman.schoolmanagementsystem.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StudentService {


    void createStudentFromRegis(StudentRegisterDTO studentRegisterDTO);

    Student addGradesToSheet(Long sId, Long eId, Integer score);


    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    void studentPartialUpdate(Long id, StudentRegisterDTO updatedStudent);

    void deleteStudent(Long id);

    void studentPartialUpdateUsingReflection(Long id, StudentRegisterDTO studentUpdate) throws IllegalAccessException;
}
