package com.abdelrahman.schoolmanagementsystem.entity;


import com.abdelrahman.schoolmanagementsystem.validation.Phone;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Guardian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "guardianIdGen")
    @SequenceGenerator(name = "guardianIdGen", allocationSize = 1)
    private Long guardianId;

    @NotBlank
    private String guardianName;

    @NotBlank
    private String guardianRelation;

    @Phone
    private String guardianPhoneNumber;

    /*@OneToMany(mappedBy = "guardian")
    @NotNull
    List<Student> student;*/
}
