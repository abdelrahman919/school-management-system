package com.abdelrahman.schoolmanagementsystem.entity;

import com.abdelrahman.schoolmanagementsystem.Enums.DaysOfTheWeek;
import com.abdelrahman.schoolmanagementsystem.Enums.Period;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.transaction.jta.platform.internal.SunOneJtaPlatform;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TimeTableEntry {

    DaysOfTheWeek day;

    Period period;

    Subject subject;

    Teacher teacher;



}
