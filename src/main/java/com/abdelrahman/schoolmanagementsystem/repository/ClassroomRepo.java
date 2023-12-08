package com.abdelrahman.schoolmanagementsystem.repository;

import com.abdelrahman.schoolmanagementsystem.entity.Classroom;
import com.abdelrahman.schoolmanagementsystem.enums.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepo extends JpaRepository<Classroom,Long> {



}
