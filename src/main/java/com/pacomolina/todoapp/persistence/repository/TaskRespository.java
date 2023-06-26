package com.pacomolina.todoapp.persistence.repository;

import com.pacomolina.todoapp.persistence.entity.Task;
import com.pacomolina.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * Con este repositorio podremos acceder a nuestra base de datos
 * */

public interface TaskRespository extends JpaRepository<Task, Long> {

    // Vamos a pedir las tareas por estados de la misma
    public List<Task> findAllByTaskStatus(TaskStatus status);


    //Poder marcar las tareas como cumplidas
    @Modifying
    @Query(value = "UPDATE TASK SET FINISHED = TRUE WHERE ID =:id ", nativeQuery = true)
    public void markTaskFinished(@Param("id") Long id);
}
