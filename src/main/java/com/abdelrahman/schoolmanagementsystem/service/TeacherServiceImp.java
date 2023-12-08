package com.abdelrahman.schoolmanagementsystem.service;

import com.abdelrahman.schoolmanagementsystem.dto.teacher.TeacherDto;
import com.abdelrahman.schoolmanagementsystem.dto.teacher.TeacherRegisterDTO;
import com.abdelrahman.schoolmanagementsystem.entity.Classroom;
import com.abdelrahman.schoolmanagementsystem.entity.Teacher;
import com.abdelrahman.schoolmanagementsystem.mappers.TeacherMapper;
import com.abdelrahman.schoolmanagementsystem.repository.ClassroomRepo;
import com.abdelrahman.schoolmanagementsystem.repository.TeacherRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImp implements TeacherService{

    private final TeacherRepo teacherRepo;
    private final TeacherMapper teacherMapper;
    private final ClassroomRepo classroomRepo;


    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepo.findAll();

    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<TeacherDto> getAllTeacherDTO() {
        return teacherRepo.findAll().stream().map(teacherMapper::teacherToDto).toList();
    }

    @Override
    public TeacherDto getTeacherDtoById(Long id) {
        Teacher teacher = teacherRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        return teacherMapper.teacherToDto(teacher);
    }


    @Override
    public Teacher createTeacher(TeacherRegisterDTO teacherRegisterDTO) {
        Teacher teacher = teacherMapper.registerDTOToTeacher(teacherRegisterDTO);
        return teacherRepo.save(teacher);
    }

    @Override
    public void updateTeacher(Long id, Teacher updatedTeacher) {
        Teacher teacher= teacherRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        teacherMapper.updateTeacher(updatedTeacher,teacher);
        teacherRepo.save(teacher);

    }

    @Override
    public void addTeachersToClass(Long cId, List<Long> ids) {
        Classroom classroom= classroomRepo.findById(cId).orElseThrow(EntityNotFoundException::new);
        List<Teacher> teachers = teacherRepo.findAllById(ids);
        teachers.forEach(teacher -> teacher.getClassrooms().add(classroom));
        teacherRepo.saveAll(teachers);
    }



}
