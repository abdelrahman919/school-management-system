package com.abdelrahman.schoolmanagementsystem.service;

import com.abdelrahman.schoolmanagementsystem.entity.Exam;
import com.abdelrahman.schoolmanagementsystem.repository.ExamRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ExamServiceImp implements ExamService{

    private final ExamRepo examRepo;



    @Override
    public Exam createExam(Exam exam) {
        return examRepo.save(exam);
    }
}
