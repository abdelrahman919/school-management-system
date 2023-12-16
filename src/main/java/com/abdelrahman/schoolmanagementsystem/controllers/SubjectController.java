package com.abdelrahman.schoolmanagementsystem.controllers;

import com.abdelrahman.schoolmanagementsystem.entity.Subject;
import com.abdelrahman.schoolmanagementsystem.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sub")
public class SubjectController {

    private final SubjectService subjectService;


    @GetMapping
    public List<Subject>getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable("id") String id) {
        return subjectService.getSubjectById(id);
    }



    @PostMapping
    public Subject createSubject(@RequestBody Subject subject){
        return subjectService.createSubject(subject);
    }
}
