package com.melchor.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id; 
    private String task;
    private boolean complete;

    public Task() {}

    public Task(String task) {
        this.task = task;
        this.complete = false;
    }

    @Override
    public String toString() {
    return String.format(
        "Task[id=%d, task='%s', complete='%b']",
        id, task, complete);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
    
    
}
