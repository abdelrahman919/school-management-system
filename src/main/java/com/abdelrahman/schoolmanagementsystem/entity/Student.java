package com.abdelrahman.schoolmanagementsystem.entity;


import com.abdelrahman.schoolmanagementsystem.Enums.Gender;
import com.abdelrahman.schoolmanagementsystem.Enums.Level;
import com.abdelrahman.schoolmanagementsystem.validation.Phone;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    private String studentFullName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;



    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate enrollmentDate;

    @NotNull
    private Gender gender;


    @Phone
    private String phoneNumber;


    @ManyToOne(cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    @JoinColumn()
    private Guardian guardian;

    @NotBlank
    private String address;


    private Level level ;

    @OneToMany//TODO
    private List<Grade> gradeSheet;


  //  private AttendanceRecord attendanceRecord;

    @ManyToOne //TODO
    private Classroom classroom;


    private boolean isEnabled = false;


    private boolean passed;






}
