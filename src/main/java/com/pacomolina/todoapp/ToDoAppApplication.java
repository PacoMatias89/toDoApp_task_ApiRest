package com.pacomolina.todoapp;

import com.pacomolina.todoapp.persistence.entity.Task;
import com.pacomolina.todoapp.persistence.entity.TaskStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ToDoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
	}



}
