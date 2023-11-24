package com.abdelrahman.schoolmanagementsystem.entity;


import com.abdelrahman.schoolmanagementsystem.validation.Phone;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "studentIdGen")
    @SequenceGenerator(name = "studentIdGen", allocationSize = 1)
    Integer studentId;

    @NotEmpty
    String studentFullName;

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate dateOfBirth;

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate enrollmentDate;

    @NotNull
    Gender gender;

    //@Pattern(regexp= "^0(10|11|12|15)[0-9]{8}$")
    @Phone
    String phoneNumber;


    @OneToMany(mappedBy = "student")

    List<Guardian> guardian;

    String address;





    Level level ;


   // GradeSheet gradeSheet;


  //  AttendanceRecord attendanceRecord;


    boolean isEnabled = false;


    boolean passed;






}
