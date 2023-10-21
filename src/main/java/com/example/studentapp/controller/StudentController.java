package com.example.studentapp.controller;

import com.example.studentapp.model.StudentModel;
import com.example.studentapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public String getStudentList() {
        return "persons/personList";
    }

    @GetMapping("/addStudent")
    public String getAddStudent() {
        return "persons/addNewPerson";
    }

    @GetMapping("/editStudent")
    public String getEditStudent() {
        return "persons/editPerson";
    }
    // get bo pobieramy tylko widoki póki co.
    // metody do POST, PUT musimy stworzyc osobno

    @PostMapping("/addStudent")
    public RedirectView postAddStudent(StudentModel studentModel) {
        studentService.addStudent(studentModel);
        return new RedirectView("/students");
    }
    // REdirectView- jak wbijemy metode post mapping- add student
    // i uzupelnimy parametry i dodamy studenta, to jak wejde w ta metode
    // w tej metodzie typ zwracany bedzie redirectview- spowoduje przekierowanie
    // do innego adresu URL w obrebie naszej aplikacji.

}
