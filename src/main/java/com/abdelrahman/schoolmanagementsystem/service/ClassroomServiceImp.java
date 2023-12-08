package com.abdelrahman.schoolmanagementsystem.service;

import com.abdelrahman.schoolmanagementsystem.dto.ClassroomDTO;
import com.abdelrahman.schoolmanagementsystem.entity.Classroom;
import com.abdelrahman.schoolmanagementsystem.mappers.ClassroomMapper;
import com.abdelrahman.schoolmanagementsystem.repository.ClassroomRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImp implements ClassroomService {

    private final ClassroomRepo classroomRepo;
    private final ClassroomMapper classroomMapper;




    @Override
    public List<Classroom> findAll() {
        return classroomRepo.findAll();
    }

    @Override
    public Classroom getClassroomById(Long id) {
        return classroomRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Classroom createClassroom(Classroom classroom) {
        return  classroomRepo.save(classroom);
    }

    @Override
    public List<ClassroomDTO> findAlldto() {
        return classroomRepo.findAll().stream().map(classroomMapper::classroomToDTO)
                .toList();

    }

    @Override
    public ClassroomDTO getClassroomDtoById(Long id) {
        return classroomMapper.classroomToDTO(classroomRepo.findById(id)
                .orElseThrow(EntityNotFoundException::new));
    }


    @Override
    public void deleteClassroom(Long id) {
        Classroom classroom= classroomRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        classroomRepo.delete(classroom);
    }


}
