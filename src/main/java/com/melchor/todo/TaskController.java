package com.melchor.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class TaskController {
    @Autowired
    private TaskRepository repository;

	@GetMapping("/")
	public String index(Model model) {
		Iterable<Task> todoList = repository.findAll();
		model.addAttribute("tasks", new TodoListViewModel(todoList));
		model.addAttribute("newtask", new Task());
    	return "index";
	}

	@PostMapping("/addtask")
	public String add(@ModelAttribute Task requestItem) {
		Task task = new Task(requestItem.getTask());
		repository.save(task);
	  	return "redirect:/";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute TodoListViewModel requestItems) {
		for (Task requestItem : requestItems.getTodoList() ) {
			Task task = new Task(requestItem.getTask());
			task.setComplete(requestItem.isComplete());
			task.setId(requestItem.getId());
			repository.save(task);
		}
		return "redirect:/";
	}
}

