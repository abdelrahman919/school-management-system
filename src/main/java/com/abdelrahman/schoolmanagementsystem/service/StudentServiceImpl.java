package com.abdelrahman.schoolmanagementsystem.service;

import com.abdelrahman.schoolmanagementsystem.dto.StudentDto;
import com.abdelrahman.schoolmanagementsystem.dto.StudentRegisterDTO;
import com.abdelrahman.schoolmanagementsystem.entity.Exam;
import com.abdelrahman.schoolmanagementsystem.entity.Student;
import com.abdelrahman.schoolmanagementsystem.mappers.StudentMapper;
import com.abdelrahman.schoolmanagementsystem.repository.ExamRepo;
import com.abdelrahman.schoolmanagementsystem.repository.StudentRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    private final ExamRepo examRepo;



    @Override
    public List<StudentDto> getAllStudents() {
        return studentRepo.findAll().stream().map(studentMapper::studentToDto)
                .collect(Collectors.toList());

    }

    @Override
    public StudentDto getStudentById(Long id) {
        return studentRepo.findById(id).map(studentMapper::studentToDto)
                .orElseThrow(EntityNotFoundException::new);

    }

    @Override
    public void createStudentFromRegis(StudentRegisterDTO studentRegisterDTO) {
        Student student= studentMapper.studentRegDtoToStudent(studentRegisterDTO);
        studentRepo.save(student);
    }

    @Override
    public void studentPartialUpdate(Long id, StudentRegisterDTO updatedStudent) {
        Student student= studentRepo.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        student= studentMapper.updateStudentFields(updatedStudent,student);
        studentRepo.save(student);

    }

    //THIS METHOD IS THE SAME AS studentPartialUpdate BUT
    //DOESN'T REQUIRE MODLE MAPPER AND IMPLEMENTED MAINLY FOR PRACTICE
    @Override
    public void studentPartialUpdateUsingReflection(Long id, StudentRegisterDTO studentUpdate)
            throws IllegalAccessException {

        Student student= studentRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        Field[] studentFields = student.getClass().getDeclaredFields();
        Field[] updatedFields = studentUpdate.getClass().getDeclaredFields();

        for(Field updatedField: updatedFields){
            for (Field field : studentFields){
                field.setAccessible(true);
                updatedField.setAccessible(true);

                if (field.getName().equals(updatedField.getName())
                        && updatedField.get(studentUpdate) != null) {
                    field.set(student,updatedField.get(studentUpdate));
                    break;
                }
            }

        }
        studentRepo.save(student);
    }


    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }


    @Override
    public Student addGradesToSheet(Long sId, Long eId, Integer score) {
        Student student= studentRepo.findById(sId).orElseThrow(EntityNotFoundException::new);
        Exam exam = examRepo.findById(eId).orElseThrow(EntityNotFoundException::new);
        student.getGradeSheet().put(exam,score);
        studentRepo.save(student);
        return student;
    }













}
