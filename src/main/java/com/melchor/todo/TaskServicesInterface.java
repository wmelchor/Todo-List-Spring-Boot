package com.melchor.todo;

import java.util.List;

public interface TaskServicesInterface {
    List<Task> getAllTasks();
    void save(Task task);
    Task getById(long id);
    void deleteById(long id);
}
