package com.pacomolina.todoapp.service.dto;



import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TaskInDto {

    private String title;
    private String description;

    //Fecha de finalización estimada
    private LocalDateTime eta;


}
