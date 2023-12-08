package com.abdelrahman.schoolmanagementsystem.dto;


import com.abdelrahman.schoolmanagementsystem.entity.TimeTable;
import com.abdelrahman.schoolmanagementsystem.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomDTO {

   // private Level level;

   // private String number;

    private String className;

    private TimeTable timeTable;





}
