package com.abdelrahman.schoolmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Exam implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "examIdGen")
    @SequenceGenerator(name = "examIdGen", allocationSize = 1)
    private Long id;


    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Subject subject;



    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

  //  @NotNull
    private Integer maxScore;

  //  @NotNull
    private Integer passScore;





}
