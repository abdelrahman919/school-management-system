package com.abdelrahman.schoolmanagementsystem.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Subject {

    private String title;

    @OneToMany //TODO
    private List<Teacher> teachers;



















}
