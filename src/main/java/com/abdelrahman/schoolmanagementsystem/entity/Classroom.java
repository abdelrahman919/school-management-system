package com.abdelrahman.schoolmanagementsystem.entity;

import com.abdelrahman.schoolmanagementsystem.Enums.Level;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "classIdGen")
    @SequenceGenerator(name = "classIdGen", allocationSize = 1)
    private Integer classroomId;

    @NotEmpty(message = "Please enter class name. ")
    private String name;

    @NotEmpty(message = "Please enter class level")
    private Level level;

    @OneToMany //TODO
    private List<Student> students;

    @ManyToMany //TODO
    private List<Teacher> teachers;

    @OneToOne
    private TimeTable timeTable;

    











}
