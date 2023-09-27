package com.melchor.todo;

import org.springframework.data.jpa.repository.JpaRepository;

/*  JpaRepository is an interface from Spring Data JPA (In XML). It's designed to simplify the creation of data repositories in a Spring application. 
 *  Thanks to extending CrudRepository, we get basic CRUD (Create, Read, Update, Delete) operations without having to write the implementation code for these operations,
 *  we also get stuff like save, findById, findAll, and delete.
*/
public interface TaskRepository extends JpaRepository<Task, Long> {
}
