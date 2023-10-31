package com.example.studentapp.controller;

import com.example.studentapp.model.StudentModel;
import com.example.studentapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public String getStudentList(Model model) {
        List<StudentModel> studentList = studentService.getStudentList();
        model.addAttribute("studentModel", studentList);
        return "persons/personList";
    } // tutaj model.addAtrubutte przekazujemy liste obiektow do widoku personlist.
    // poprzez atrybut "studentModel" bedziemy odnosci sie do frontendu czyli przekazywac do widoku.


    @GetMapping("/addStudent")
    public String getAddStudent() {
        return "persons/addNewPerson";
    }

    @GetMapping("/editStudent/{id}")
    public String getEditStudent(@PathVariable("id") Long id, Model model) {
//        log.info("path: {}", id);
        StudentModel studentModel = studentService.getStudentById(id);
        model.addAttribute("student",studentModel);
        return "persons/editPerson";
    }
    // get bo pobieramy tylko widoki póki co.
    // metody do POST, PUT musimy stworzyc osobno

    @PostMapping("/addStudent")
    public RedirectView postAddStudent(StudentModel studentModel) {
        studentService.addStudent(studentModel);
        return new RedirectView("/students");
    }
    // RedirectView- jak wbijemy metode post mapping- add student
    // i uzupelnimy parametry i dodamy studenta, to jak wejde w ta metode
    // w tej metodzie typ zwracany bedzie redirectview- spowoduje przekierowanie
    // do innego adresu URL w obrebie naszej aplikacji.

    @PostMapping("/editStudent/{id}")
    public RedirectView postEditStudent(@PathVariable("id") Long id, StudentModel editStudent) {
//        log.info("path: {}", id);
       studentService.saveEditStudent(editStudent);
        return new RedirectView("/editStudent/{id}");
    }
    @PostMapping("/del/{id}")
    public RedirectView delEditStudent(@PathVariable("id") Long id) {
        studentService.delStudent(id);
        return new RedirectView("/students");
    }

}
