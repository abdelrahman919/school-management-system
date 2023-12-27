package com.abdelrahman.schoolmanagementsystem.service;

import com.abdelrahman.schoolmanagementsystem.dto.student.StudentDto;
import com.abdelrahman.schoolmanagementsystem.dto.student.StudentRegisterDTO;
import com.abdelrahman.schoolmanagementsystem.entity.AttendanceRecord;
import com.abdelrahman.schoolmanagementsystem.entity.Classroom;
import com.abdelrahman.schoolmanagementsystem.entity.Exam;
import com.abdelrahman.schoolmanagementsystem.entity.Student;
import com.abdelrahman.schoolmanagementsystem.mappers.StudentMapper;
import com.abdelrahman.schoolmanagementsystem.repository.ClassroomRepo;
import com.abdelrahman.schoolmanagementsystem.repository.ExamRepo;
import com.abdelrahman.schoolmanagementsystem.repository.StudentRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    private final ExamRepo examRepo;
    private final ClassroomRepo classroomRepo;




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

    @Override
    public void addStudentsToClass(Long cId, List<Long> ids) {

        Classroom classroom = classroomRepo.findById(cId).orElseThrow(EntityNotFoundException::new);
        List<Student> students= studentRepo.findAllById(ids);
        students.forEach(student ->  student.setClassroom(classroom));
        studentRepo.saveAll(students);

    }

    @Override
    public void addDaysToRecord(Long id, Map<LocalDate, Boolean> date) {
        Student student = studentRepo.findById(id).orElseThrow(EntityNotFoundException::new);

        if (student.getAttendanceRecord() == null) {
            student.setAttendanceRecord(new AttendanceRecord());
        }
        student.getAttendanceRecord().getAbsenceDays().putAll(date);
        studentRepo.save(student);

    }



}
