package com.abdelrahman.schoolmanagementsystem.mappers;

import com.abdelrahman.schoolmanagementsystem.dto.ClassroomDTO;
import com.abdelrahman.schoolmanagementsystem.dto.teacher.TeacherDto;
import com.abdelrahman.schoolmanagementsystem.dto.teacher.TeacherRegisterDTO;
import com.abdelrahman.schoolmanagementsystem.entity.Teacher;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class TeacherMapper {

    private final ModelMapper modelMapper;
    private final ClassroomMapper classroomMapper;


    public TeacherDto teacherToDto(Teacher teacher){
        //STRICT MAPPING TO REMOVE CONFUSION BETWEEN DTO'S NAME
        //AND TEACHER FIRST AND LAST NAME
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        TeacherDto teacherDto = modelMapper.map(teacher, TeacherDto.class);
        teacherDto.setTeacherName(teacher.getFirstName()+" "+teacher.getLastName());
        //ELIMINATING POSSIBILITY OF A NULL LIST AND MAPPING CLASSES TO DTOS
        List<ClassroomDTO> classroomDTOS = teacher.getClassrooms().stream().filter(Objects::nonNull)
                .map(classroomMapper::classroomToDTO).toList();
        teacherDto.setClassroomDTOS(classroomDTOS);

        return teacherDto;
    }

    public Teacher registerDTOToTeacher(TeacherRegisterDTO teacherRegisterDTO) {
        return modelMapper.map(teacherRegisterDTO,Teacher.class);
    }


    public void updateTeacher(Teacher updatedTeacher, Teacher oldTeacher){
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(updatedTeacher,oldTeacher);
    }






}
