package com.abdelrahman.schoolmanagementsystem.dto.teacher;

import com.abdelrahman.schoolmanagementsystem.dto.ClassroomDTO;
import com.abdelrahman.schoolmanagementsystem.entity.Classroom;
import com.abdelrahman.schoolmanagementsystem.entity.Subject;
import com.abdelrahman.schoolmanagementsystem.entity.TimeTable;
import com.abdelrahman.schoolmanagementsystem.enums.Level;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
@Data
public class TeacherDto {

    private String teacherName;

    private List<Level> levels;

    private Subject subject;

    private List<ClassroomDTO> classroomDTOS;
    private TimeTable timeTable;
}
