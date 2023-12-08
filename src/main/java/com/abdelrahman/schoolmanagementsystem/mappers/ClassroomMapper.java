package com.abdelrahman.schoolmanagementsystem.mappers;

import com.abdelrahman.schoolmanagementsystem.dto.ClassroomDTO;
import com.abdelrahman.schoolmanagementsystem.entity.Classroom;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClassroomMapper {

    private final ModelMapper modelMapper;

    public ClassroomDTO classroomToDTO(Classroom classroom){

        ClassroomDTO classroomDTO = modelMapper.map(classroom,ClassroomDTO.class);
        classroomDTO.setClassName(classroom.getNumber() + "-" +classroom.getLevel().getAbbreviation());
        return classroomDTO;

    }



}
