package com.abdelrahman.schoolmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.web.JsonPath;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AttendanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "attendanceRecordGen")
    @SequenceGenerator(name = "attendanceRecordGen",allocationSize = 1)
    @JsonIgnore
    private Long id;

    @ElementCollection
    @JsonFormat(pattern = "dd-MM-yyyy")
    @MapKeyColumn(name = "date")
    @Column(name = "with_excuse")
    private Map<LocalDate,Boolean> absenceDays;

    @Transient
    private int absenceDaysCount;

    @Transient
    private int daysWithExcuse;


    public int getAbsenceDaysCount() {
        return absenceDays != null ? absenceDays.size() : 0;
    }

    public int getDaysWithExcuse() {
        if (absenceDays != null) {
            for (Boolean value : absenceDays.values()) {
                if (value) {
                    daysWithExcuse++;
                }
            }
        return daysWithExcuse;
        }
        return daysWithExcuse;
    }




}
