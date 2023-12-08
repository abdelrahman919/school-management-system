package com.abdelrahman.schoolmanagementsystem.repository;

import com.abdelrahman.schoolmanagementsystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Long> {
}
