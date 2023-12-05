package com.abdelrahman.schoolmanagementsystem.repository;


import com.abdelrahman.schoolmanagementsystem.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepo extends JpaRepository<Exam,Long> {


}
