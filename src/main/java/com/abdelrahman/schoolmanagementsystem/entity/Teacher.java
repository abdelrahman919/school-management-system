package com.abdelrahman.schoolmanagementsystem.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "teacherIdGen")
    @SequenceGenerator(name = "teacherIdGen",allocationSize = 1)
    Long teacherId;

    String teacherFirstName;

    String teacherLastName;

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate dateOfBirth;









}
