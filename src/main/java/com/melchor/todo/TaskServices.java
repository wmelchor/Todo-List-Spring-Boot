package com.melchor.todo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServices implements TaskServicesInterface{
    
    @Autowired private TaskRepository taskRepository;

    @Override public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override public void save(Task task) {
        taskRepository.save(task);
    }

    @Override public Task getById(long id) {
        Optional<Task> optional = taskRepository.findById(id);
        Task task = null;
        if(optional.isPresent()) {
            task = optional.get();
        } else {
            throw new RuntimeException("Task not found for id : " + id);
        }
        return task;
    } 

    @Override public void deleteById(long id) {
        taskRepository.deleteById(id);
    }
}
