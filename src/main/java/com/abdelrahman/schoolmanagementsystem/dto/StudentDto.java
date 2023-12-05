package com.abdelrahman.schoolmanagementsystem.dto;


import com.abdelrahman.schoolmanagementsystem.entity.AttendanceRecord;
import com.abdelrahman.schoolmanagementsystem.entity.Classroom;
import com.abdelrahman.schoolmanagementsystem.entity.Exam;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Map;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {

    private String fullName;

    private Classroom classroom;

    private Map<Exam,Integer> gradeSheet;

    private AttendanceRecord attendanceRecord;


}
