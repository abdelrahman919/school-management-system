package com.abdelrahman.schoolmanagementsystem.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Subject {

/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "subjectIdGen")
    @SequenceGenerator(name = "subjectIdGen",allocationSize = 1)
    private Long id;*/

    @Id
    private String name;























}
