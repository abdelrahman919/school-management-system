package com.abdelrahman.schoolmanagementsystem.service;

import com.abdelrahman.schoolmanagementsystem.entity.Subject;
import com.abdelrahman.schoolmanagementsystem.repository.SubjectRepo;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImp implements SubjectService{

    private final SubjectRepo subjectRepo;



    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepo.findAll();
    }

    @Override
    public Subject getSubjectById(String id) {
        return subjectRepo.findById(id).orElseThrow(EntityExistsException::new);
    }


    @Override
    public Subject createSubject(Subject subject) {
        return subjectRepo.save(subject);
    }


}
