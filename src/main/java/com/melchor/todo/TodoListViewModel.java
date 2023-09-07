package com.melchor.todo;

import java.util.ArrayList;

import jakarta.validation.Valid;

import org.springframework.validation.annotation.Validated;

@Validated
public class TodoListViewModel {

	@Valid
	private ArrayList<Task> todoList = new ArrayList<Task>();
	
	public TodoListViewModel() {}
	
	public TodoListViewModel(Iterable<Task> items) {
		items.forEach(todoList:: add);
	}

	public TodoListViewModel(ArrayList<Task> todoList) {
		this.todoList = todoList;
	}

	public ArrayList<Task> getTodoList() {
		return todoList;
	}

	public void setTodoList(ArrayList<Task> todoList) {
		this.todoList = todoList;
	}
}
