package com.example.studentapp.service;

import com.example.studentapp.model.StudentModel;
import com.example.studentapp.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    // wstrzykniecie przez konstruktor- required Args contructor
    // wywolujemy operacje ze student repository

    // metoda addStudent kontynuuje to co zostalo wykonane w PostMapping od strony frontu
    // w payloadzie (parametry) z zadaniem http z postem moge wyslac
    // odbieramy paczke z frontu z danymi i dalej je przetwarzamy - logika od backendu
    public void addStudent(StudentModel studentModel) {
        studentRepository.save(studentModel);
    }

    public List<StudentModel> getStudentList(){
        return studentRepository.findAll();
    } // findAll metoda z JPA Repository

    public StudentModel getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
        // Optional obchodzimy zw ten sposob
    }

    public void saveEditStudent(StudentModel editStudent) {
        studentRepository.save(editStudent);
    }

    public void delStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
