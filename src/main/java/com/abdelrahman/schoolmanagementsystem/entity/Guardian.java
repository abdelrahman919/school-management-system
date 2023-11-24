package com.abdelrahman.schoolmanagementsystem.entity;


import com.abdelrahman.schoolmanagementsystem.validation.Phone;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Guardian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "guardianIdGen")
    @SequenceGenerator(name = "guardianIdGen", allocationSize = 1)
    Long guardianId;

    @NotBlank
    String guardianName;

    @NotBlank
    String guardianRelation;

    @Phone
    String guardianPhoneNumber;

    @ManyToOne(fetch = FetchType.EAGER,
                cascade = CascadeType.ALL)
    @JoinColumn(name ="student_id"
            ,referencedColumnName = "studentId")
    Student student;
}
