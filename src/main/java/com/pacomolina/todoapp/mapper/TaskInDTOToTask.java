package com.pacomolina.todoapp.mapper;

import com.pacomolina.todoapp.persistence.entity.Task;
import com.pacomolina.todoapp.persistence.entity.TaskStatus;
import com.pacomolina.todoapp.service.dto.TaskInDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 *
 * Esta clase es la encargada de mapear los datos de TaskInDto a Task
 * */
@Component
public class TaskInDTOToTask implements IMapper<TaskInDto, Task> {
    @Override
    public Task map(TaskInDto in) {
        Task  task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreateDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}
