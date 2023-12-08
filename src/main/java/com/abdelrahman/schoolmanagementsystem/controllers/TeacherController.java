package com.abdelrahman.schoolmanagementsystem.controllers;


import com.abdelrahman.schoolmanagementsystem.dto.teacher.TeacherDto;
import com.abdelrahman.schoolmanagementsystem.dto.teacher.TeacherRegisterDTO;
import com.abdelrahman.schoolmanagementsystem.entity.Teacher;
import com.abdelrahman.schoolmanagementsystem.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/t")
public class TeacherController {

    private final TeacherService teacherService;


    @GetMapping
    public List<Teacher> getAllTeacher() {
        return teacherService.getAllTeacher();
    }


    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable("id") Long id){
        return teacherService.getTeacherById(id);
    }


    @GetMapping("/dto")
    public List<TeacherDto> getAllTeacherDTO(){
       return teacherService.getAllTeacherDTO();
    }


    @GetMapping("/dto/{id}")
    public TeacherDto getTeacherDtoById(@PathVariable("id")Long id){
        return teacherService.getTeacherDtoById(id);
    }


    @PostMapping
    public Teacher createTeacher(@RequestBody TeacherRegisterDTO teacherRegisterDTO){
        return teacherService.createTeacher(teacherRegisterDTO);
    }


    @PostMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable("id") Long id,
                                                 @RequestBody Teacher updatedTeacher){
        teacherService.updateTeacher(id,updatedTeacher);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/class/{cId}")
    public ResponseEntity<Teacher> addTeachersToClass(@PathVariable("cId") Long cId,
                                                      @RequestBody List<Long> ids){
        teacherService.addTeachersToClass(cId,ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }










}

