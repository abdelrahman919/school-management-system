package com.abdelrahman.schoolmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "examIdGen")
    @SequenceGenerator(name = "examIdGen", allocationSize = 1)
    private Long examId;

    @ManyToOne//TODO
    private Subject subject;

    @ManyToMany //TODO
    private List<Student> students;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @NotNull
    private Integer maxScore;

    @NotNull
    private Integer passScore;

    @OneToMany //TODO
    private List <Grade> grades;
}
