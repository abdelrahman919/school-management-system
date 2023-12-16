package com.abdelrahman.schoolmanagementsystem.repository;


import com.abdelrahman.schoolmanagementsystem.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,String> {


}
