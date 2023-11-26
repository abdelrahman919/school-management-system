package com.abdelrahman.schoolmanagementsystem.entity;


import com.abdelrahman.schoolmanagementsystem.Enums.Level;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "teacherIdGen")
    @SequenceGenerator(name = "teacherIdGen",allocationSize = 1)
    private Long teacherId;

    @NotEmpty(message = "Please enter your first name ")
    private String teacherFirstName;

    @NotEmpty(message = "Please enter your last name ")
    private String teacherLastName;

    @NotEmpty
    private String password;

    @ManyToOne //TODO
    private Subject subject;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate enrollmentDate;

    @ManyToMany //TODO
    private Classroom classroom;

    @ManyToMany //TODO
    private Level level;





}
