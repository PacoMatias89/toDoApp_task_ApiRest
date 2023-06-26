package com.pacomolina.todoapp.service;

import com.pacomolina.todoapp.exceptions.TodoExceptions;
import com.pacomolina.todoapp.mapper.TaskInDTOToTask;
import com.pacomolina.todoapp.persistence.entity.Task;
import com.pacomolina.todoapp.persistence.entity.TaskStatus;
import com.pacomolina.todoapp.persistence.repository.TaskRespository;
import com.pacomolina.todoapp.service.dto.TaskInDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 *
 * Esta clase será la encargada de crear las nuevas tareas de nuestra aplicación
 * */
@Service
public class TaskService {

    /*
    * Inyectamos las dependencias basadas en el constructor de spring boot
    * La buena praxis es con constructor
    * */

    private final TaskRespository respository;
    private final TaskInDTOToTask mapper;


    public TaskService(TaskRespository respository, TaskInDTOToTask mapper) {
        this.respository = respository;
        this.mapper = mapper;
    }

//    Ya tendremos mapeado las tareas
    public Task createTask(TaskInDto taskInDto) {
        Task task = mapper.map(taskInDto);
        return this.respository.save(task);
    }

    //Con este método devolverá todas las tareas
    public List<Task> findAll(){
        return this.respository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus status){
        return this.respository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskAsFinished(Long id){
        // Buscamos si el id existe
        Optional<Task> optionalTask = this.respository.findById(id);

        if (optionalTask.isEmpty()){
            throw new TodoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }


        this.respository.markTaskFinished(id);
    }

    public void deliteById(Long id){
        // Buscamos si el id existe
        Optional<Task> optionalTask = this.respository.findById(id);

        if (optionalTask.isEmpty()){
            throw new TodoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }


        this.respository.deleteById(id);
    }
}
