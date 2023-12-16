package com.abdelrahman.schoolmanagementsystem.dto.teacher;


import com.abdelrahman.schoolmanagementsystem.entity.Classroom;
import com.abdelrahman.schoolmanagementsystem.entity.Subject;
import com.abdelrahman.schoolmanagementsystem.entity.TimeTable;
import com.abdelrahman.schoolmanagementsystem.enums.Level;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherRegisterDTO {


    @NotEmpty(message = "Please enter your first name ")
    private String firstName;


    @NotEmpty(message = "Please enter your last name ")
    private String lastName;


    @Email(regexp = "^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$",
            message = "Enter a valid email ")
    @Column(unique = true)
    private String email;


    @NotEmpty
    private String password;



    private List<Subject> subjects;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate enrollmentDate;


    @NotNull
    @ElementCollection(targetClass = Level.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable
    private List<Level> levels;



}
