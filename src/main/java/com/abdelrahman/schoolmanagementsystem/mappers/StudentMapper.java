package com.abdelrahman.schoolmanagementsystem.mappers;

import com.abdelrahman.schoolmanagementsystem.dto.student.StudentDto;
import com.abdelrahman.schoolmanagementsystem.dto.student.StudentRegisterDTO;
import com.abdelrahman.schoolmanagementsystem.entity.Student;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentMapper {

    private final ModelMapper modelMapper;
    private final ClassroomMapper classroomMapper;


    public Student studentRegDtoToStudent(StudentRegisterDTO studentRegisterDTO){

        return modelMapper.map(studentRegisterDTO,Student.class);
    }

    public StudentDto studentToDto(Student student){
        StudentDto studentDto= modelMapper.map(student,StudentDto.class);
        if (student.getClassroom() != null) {
            studentDto.setClassroomDTO(classroomMapper.
                    classroomToDTO(student.getClassroom()));
        }
        return studentDto;
    }

    public Student updateStudentFields(StudentRegisterDTO updatedStudent, Student student){
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(updatedStudent,student);
        return student;

    }




}
