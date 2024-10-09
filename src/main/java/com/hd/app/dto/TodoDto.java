package com.hd.app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TodoDto {
    int id;
    int userId;
    String name;
    String description;
    LocalDate dueDate;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    boolean isCompleted;

}