package com.abdelrahman.schoolmanagementsystem.dto.student;


import com.abdelrahman.schoolmanagementsystem.dto.ClassroomDTO;
import com.abdelrahman.schoolmanagementsystem.entity.AttendanceRecord;
import com.abdelrahman.schoolmanagementsystem.entity.Exam;
import lombok.*;

import java.util.Map;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {

    private String fullName;

    private ClassroomDTO classroomDTO;

    private Map<Exam,Integer> gradeSheet;

    private AttendanceRecord attendanceRecord;


}
