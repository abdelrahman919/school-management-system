package com.abdelrahman.schoolmanagementsystem.controllers;

import com.abdelrahman.schoolmanagementsystem.dto.ClassroomDTO;
import com.abdelrahman.schoolmanagementsystem.entity.Classroom;
import com.abdelrahman.schoolmanagementsystem.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/class")
public class ClassroomController {

    private final ClassroomService classroomService;


    @GetMapping
    public List<Classroom> getAllClassrooms(){
        return classroomService.findAll();
    }

    @GetMapping("/{id}")
    public Classroom getClassroomById(@PathVariable("id") Long id){
        return classroomService.getClassroomById(id);
    }


    @GetMapping("/dto")
    public List<ClassroomDTO> getAllClassroomsDto(){
        return classroomService.findAlldto();
    }


    @GetMapping("/dto/{id}")
    public ClassroomDTO getClassroomDtoById(@PathVariable("id") Long id){
        return classroomService.getClassroomDtoById(id);
    }

    @PostMapping
    public Classroom createClassroom(@RequestBody  Classroom classroom){
        return classroomService.createClassroom(classroom);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Classroom> deleteClassroom(@PathVariable("id") Long id){
        classroomService.deleteClassroom(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }






}
