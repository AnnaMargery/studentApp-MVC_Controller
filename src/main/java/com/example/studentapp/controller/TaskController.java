package com.example.studentapp.controller;

import com.example.studentapp.model.TaskModel;
import com.example.studentapp.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/tasks")
    public String getTaskList(Model model) {
        List<TaskModel> taskList = taskService.getTaskList();
        model.addAttribute("taskModel", taskList);
        return "tasks/tasks";
    }

    @GetMapping("/addTask")
    public String getAddTask() {
        return "tasks/addTask";
    }

    @PostMapping("/editTask/{id}")
    public RedirectView postEditTask(@PathVariable("id") Long id, TaskModel taskToEdit) {
//        log.info("path: {}", id);
        taskService.saveEditTask(taskToEdit);
        return new RedirectView("/editTask/{id}");
    }

    @PostMapping("/delTask/{id}")
    public RedirectView deleteEditTask(@PathVariable("id") Long id) {
        taskService.deleteEditTask(id);
        return new RedirectView("/tasks");
    }


}
