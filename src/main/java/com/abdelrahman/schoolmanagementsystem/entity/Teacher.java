package com.abdelrahman.schoolmanagementsystem.entity;


import com.abdelrahman.schoolmanagementsystem.enums.Level;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "teacherIdGen")
    @SequenceGenerator(name = "teacherIdGen", allocationSize = 1)
    private Long id;


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


    @ManyToMany
    private List<Subject> subjects;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate enrollmentDate;


    @ManyToMany
    @JsonIgnoreProperties({"students","teachers"})
    private List<Classroom> classrooms;


    @NotNull
    @ElementCollection(targetClass = Level.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable
    private List<Level> levels;


    @OneToOne
    private TimeTable timeTable;


    private boolean isEnabled;

}
