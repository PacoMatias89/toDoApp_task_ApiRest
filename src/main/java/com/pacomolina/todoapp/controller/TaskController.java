package com.pacomolina.todoapp.controller;

import com.pacomolina.todoapp.persistence.entity.Task;
import com.pacomolina.todoapp.persistence.entity.TaskStatus;
import com.pacomolina.todoapp.service.TaskService;
import com.pacomolina.todoapp.service.dto.TaskInDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    // Creamos el elemento
    @PostMapping
    public Task createTask(@RequestBody TaskInDto taskInDto){
        return this.taskService.createTask(taskInDto);
    }


    // Este método es el encargado de devolver todos las listas creadas desde el taskService
    @GetMapping
    public List<Task> findAll(){
        return this.taskService.findAll();
    }
    @GetMapping("/status/{status}")
    public List<Task> findAllByStatus(@PathVariable("status")TaskStatus status){
        return this.taskService.findAllByTaskStatus(status);
    }

    @PatchMapping("/mark_as_Finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id){
        this.taskService.updateTaskAsFinished(id);
        //Retornamos el valor 204 para que la persona que consuma la api no esté esperando siempre
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable("id") Long id){
        this.taskService.deliteById(id);
        //Retornamos el valor 204 para que la persona que consuma la api no esté esprando siempre
        return ResponseEntity.noContent().build();
    }

}
