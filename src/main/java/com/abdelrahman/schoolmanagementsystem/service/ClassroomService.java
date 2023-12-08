package com.abdelrahman.schoolmanagementsystem.service;

import com.abdelrahman.schoolmanagementsystem.dto.ClassroomDTO;
import com.abdelrahman.schoolmanagementsystem.entity.Classroom;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassroomService {
    List<Classroom> findAll();

    Classroom createClassroom(Classroom classroom);

    List<ClassroomDTO> findAlldto();

    void deleteClassroom(Long id);


    Classroom getClassroomById(Long id);

    ClassroomDTO getClassroomDtoById(Long id);
}
