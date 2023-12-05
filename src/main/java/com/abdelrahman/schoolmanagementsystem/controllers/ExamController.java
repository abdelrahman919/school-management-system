package com.abdelrahman.schoolmanagementsystem.controllers;


import com.abdelrahman.schoolmanagementsystem.entity.Exam;
import com.abdelrahman.schoolmanagementsystem.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/e")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;

    @PostMapping
    public Exam createExam(@RequestBody Exam exam){
        return examService.createExam(exam);

    }



}
