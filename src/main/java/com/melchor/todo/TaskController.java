package com.melchor.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TaskController {
    @Autowired
    private TaskServices taskServices;

	@GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("alltasklist", taskServices.getAllTasks());
        return "index";
    }
 
    @GetMapping("/addnew")
    public String addNewEmployee(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "addtask";
    }
 
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("task") Task task) {
        taskServices.save(task);
        return "redirect:/";
    }
 
    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        Task task = taskServices.getById(id);
        model.addAttribute("task", task);
        return "updatetask";
    }
 
    @GetMapping("/deleteTask/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        taskServices.deleteById(id);
        return "redirect:/";
 
    }
}

