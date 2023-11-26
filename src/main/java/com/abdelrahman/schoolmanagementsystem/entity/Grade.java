package com.abdelrahman.schoolmanagementsystem.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Grade {

    @ManyToOne //TODO
    private Student student;


    @ManyToOne //TODO
    private Exam exam;

    @NotNull
    private Integer score;

    private boolean examPassed = isExamPassed();




    public boolean isExamPassed() {
        assert exam != null;
        try {
            if (score >= exam.getPassScore()) {
                return true;
            } else return false;
        }catch (NullPointerException e){
            return false;
        }


    }




}
