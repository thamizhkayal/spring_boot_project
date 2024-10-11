package com.hd.app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    int id;
    @Column
    int userId;
    @Column
    String name;
    @Column
    String description;
    @Column
    LocalDate dueDate;
    @Column
    LocalDateTime createdAt;
    @Column
    LocalDateTime updatedAt;
    @Column
    boolean completed;

    public Todo() {
        this.completed = false;
    }

    public Todo(int userId, String name, String description, LocalDate dueDate) {
        this(userId, name, description, dueDate, false);
    }

    public Todo(int userId, String name, String description, String dueDate) {

        this(userId, name, description, LocalDate.parse(dueDate), false);
    }

    public Todo(int userId, String name, String description, LocalDate dueDate, Boolean isComplted) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = isComplted;
    }

    public Todo(int userId, String name, String description, String dueDate, Boolean isComplted) {
        this(userId, name, description, LocalDate.parse(dueDate), isComplted);
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Getter & Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean isCompleted) {
        this.completed = isCompleted;
    }

}
