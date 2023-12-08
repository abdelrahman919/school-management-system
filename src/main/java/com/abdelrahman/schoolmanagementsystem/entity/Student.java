package com.abdelrahman.schoolmanagementsystem.entity;


import com.abdelrahman.schoolmanagementsystem.enums.Gender;
import com.abdelrahman.schoolmanagementsystem.enums.Level;
import com.abdelrahman.schoolmanagementsystem.validation.Phone;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "studentIdGen")
    @SequenceGenerator(name = "studentIdGen", allocationSize = 1)
    Long id;

    @NotEmpty(message = "Pleas enter your name")
    @Size(max = 60)
    private String fullName;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate enrollmentDate;


    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;


    @Phone
    private String phoneNumber;


    @NotEmpty(message = "enter a valid address")
    @Size(min = 10,max = 70)
    private String address;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Level level ;


    @Email(regexp = "^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$",
            message = "Enter a valid email ")
    @Column(unique = true)
    private String email;

    @NotEmpty
    @Size(min = 8,max = 20,
            message = "Password must be 8-20 characters" )
    private String password;


    ////////////////////////

    @ManyToOne(cascade = CascadeType.ALL)
    private Guardian guardian;



    @JsonIgnore
    @ElementCollection
    @CollectionTable(name = "student_grades",
            joinColumns = @JoinColumn(name = "student_id"))
    @MapKeyJoinColumn(name = "exam_id",referencedColumnName = "id")
    @Column(name = "score")
    Map<Exam, Integer> gradeSheet;


    @OneToOne(cascade = CascadeType.ALL)
    private AttendanceRecord attendanceRecord;


    @ManyToOne
    @JsonIgnoreProperties({"students"})
    private Classroom classroom;


    private boolean isEnabled = false;


    private boolean passed;






}
