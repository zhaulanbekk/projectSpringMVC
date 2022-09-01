package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Lesson;
import peaksoft.model.Task;
import peaksoft.service.LessonService;
import peaksoft.service.TaskService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final LessonService lessonService;

    @Autowired
    public TaskController(TaskService taskService, LessonService lessonService) {
        this.taskService = taskService;
        this.lessonService = lessonService;
    }

    @GetMapping("/{id}")
    public String getAllTask(Model model, @PathVariable Long id){
        model.addAttribute("tasks", taskService.getAllTasks(id));
        model.addAttribute("lessonId", id);
        return "/task/allTask";
    }
    @GetMapping("/newTask/{id}")
    public String addTask(Model model, @PathVariable Long id){
        model.addAttribute("task", new Task());
        model.addAttribute("lessonId",id);
        return "/task/newTask";
    }
    @PostMapping("/{id}/saveTask")
    public String saveTask(@ModelAttribute("task") Task task,
                           @PathVariable("id") Long id){
        taskService.addTask(id, task);
        return "redirect:/tasks/"+id;
    }

    @GetMapping("/updateTask/{id}/{lessonId}")
    public String updateTask(Model model,
                               @PathVariable Long id,
                               @PathVariable("lessonId") Long lessonId) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "/task/updateTask";
    }

    @PostMapping("/{id}/{lessonId}/editTask")
    public String save(@PathVariable("id") Long id,
                           @PathVariable("lessonId") Long lessonId,
                           @ModelAttribute Task task) {
       taskService.updateTask(id, task);
        return "redirect:/tasks/"+lessonId;
    }

    @PostMapping("{id}/{lessonId}/deleteTask")
    public String deleteLesson(@PathVariable Long id,
                               @PathVariable("lessonId") Long id2) {
       taskService.deleteTask(id);
        return "redirect:/tasks/"+id2;
    }
}
