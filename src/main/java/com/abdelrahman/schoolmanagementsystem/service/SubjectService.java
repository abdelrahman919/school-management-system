package com.abdelrahman.schoolmanagementsystem.service;

import com.abdelrahman.schoolmanagementsystem.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {

    public Subject createSubject(Subject subject) ;

    List<Subject> getAllSubjects();

    Subject getSubjectById(String id);
}
