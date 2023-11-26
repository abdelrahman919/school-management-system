package com.abdelrahman.schoolmanagementsystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class TimeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "timeTableGen")
    @SequenceGenerator(name = "timeTableGen",allocationSize = 1)
    Integer timeTableId;

    private Object[][] timeTable;




}
