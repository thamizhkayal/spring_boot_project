package com.hd.app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Todo {
    int id;
    int userId;
    String name;
    String description;
    LocalDate dueDate;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    boolean isCompleted;

}
