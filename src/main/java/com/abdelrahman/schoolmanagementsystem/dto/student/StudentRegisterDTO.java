package com.abdelrahman.schoolmanagementsystem.dto.student;



import com.abdelrahman.schoolmanagementsystem.config.ExamScoreMapDeserializer;
import com.abdelrahman.schoolmanagementsystem.config.ExamScoreMapSerializer;
import com.abdelrahman.schoolmanagementsystem.entity.*;
import com.abdelrahman.schoolmanagementsystem.enums.Gender;
import com.abdelrahman.schoolmanagementsystem.enums.Level;
import com.abdelrahman.schoolmanagementsystem.validation.Phone;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.time.LocalDate;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentRegisterDTO {

    @NotEmpty(message = "Pleas enter your name")
    @Size(max = 60)
    private String fullName;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate enrollmentDate;


    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;


    @Phone
    private String phoneNumber;


    @NotEmpty(message = "enter a valid address")
    @Size(min = 10,max = 70)
    private String address;


    @Enumerated(EnumType.STRING)
    private Level level ;


    @Email(message = "Enter a valid email ")
    @Column(unique = true)
    private String email;

    @NotEmpty
    @Size(min = 8,max = 20,
            message = "Password must be 8-20 characters" )
    private String password;

    private Guardian guardian;

    private Classroom classroom;

    @JsonSerialize(using = ExamScoreMapSerializer.class)
    @JsonDeserialize(using = ExamScoreMapDeserializer.class)
    Map<Exam, Integer> gradeSheet;

    AttendanceRecord attendanceRecord;



}
