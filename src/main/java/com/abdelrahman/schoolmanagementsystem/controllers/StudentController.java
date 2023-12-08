package com.abdelrahman.schoolmanagementsystem.controllers;


import com.abdelrahman.schoolmanagementsystem.dto.student.StudentDto;
import com.abdelrahman.schoolmanagementsystem.dto.student.StudentRegisterDTO;
import com.abdelrahman.schoolmanagementsystem.entity.Student;
import com.abdelrahman.schoolmanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/s")
@RequiredArgsConstructor
@Validated
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public ResponseEntity<Student> createStudentFromRegis(@RequestBody @Valid StudentRegisterDTO studentRegisterDTO){
        studentService.createStudentFromRegis(studentRegisterDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Student> studentPartialUpdate(@PathVariable("id") Long id,
                                                        @RequestBody StudentRegisterDTO updatedStudent) {

        studentService.studentPartialUpdate(id,updatedStudent);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    //THIS METHOD SERVES THE SAME PURPOSE AS studentPartialUpdate
    //AND IS JUST FOR PRACTICE
    @PostMapping("/ref/{id}")
    public void studentPartialUpdateUsingReflection(@PathVariable("id") Long id,
                                                    @RequestBody StudentRegisterDTO studentUpdate) throws IllegalAccessException {
        studentService.studentPartialUpdateUsingReflection(id,studentUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/grade/{sid}/{eid}/{score}")
    public Student addGradesToSheet(@PathVariable("sid") Long s_id,
                                    @PathVariable("eid") Long e_id,
                                    @PathVariable("score") Integer score){
        return studentService.addGradesToSheet(s_id,e_id,score);

    }

    @PostMapping("/class/{cId}")
    public ResponseEntity<Student> addStudentsToClass(@PathVariable("cId") Long cId,
                                                      @RequestBody List<Long> ids) {

        studentService.addStudentsToClass(cId,ids);
        return new ResponseEntity<>(HttpStatus.OK);

    }






}
