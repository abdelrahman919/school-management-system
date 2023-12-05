package com.abdelrahman.schoolmanagementsystem.repository;

import com.abdelrahman.schoolmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {


}
