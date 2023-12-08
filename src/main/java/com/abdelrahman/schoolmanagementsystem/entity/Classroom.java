package com.abdelrahman.schoolmanagementsystem.entity;

import com.abdelrahman.schoolmanagementsystem.enums.Level;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "classIdGen")
    @SequenceGenerator(name = "classIdGen", allocationSize = 1)
    private Long id;


    @NotEmpty(message = "Please enter class number. ")
    private String number;


    @NotNull(message = "Please enter class level")
    @Enumerated(EnumType.STRING)
    private Level level;



    @OneToMany(mappedBy = "classroom")
    @JsonIgnoreProperties("classroom")
    private List<Student> students;



    @ManyToMany(mappedBy = "classrooms")
    @JsonIgnoreProperties("classrooms")
    private List<Teacher> teachers;




    @OneToOne(cascade = CascadeType.ALL)
    private TimeTable timeTable;

    











}
