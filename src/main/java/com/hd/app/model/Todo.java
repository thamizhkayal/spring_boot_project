package com.hd.app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity(name = "todos")
public class Todo {

    @Id
    @GeneratedValue
    int id;
    @Column
    String name;
    @Column
    String description;
    @Column
    LocalDate dueDate;
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    LocalDateTime updatedAt;
    @Column
    boolean completed;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId")
    @JsonBackReference
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Todo() {
        this.completed = false;
    }

    public Todo(String name, String description, LocalDate dueDate) {
        this(name, description, dueDate, false);
    }

    public Todo(String name, String description, String dueDate) {

        this(name, description, LocalDate.parse(dueDate), false);
    }

    public Todo(String name, String description, LocalDate dueDate, Boolean isComplted) {

        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = isComplted;
    }

    public Todo(String name, String description, String dueDate, Boolean isComplted) {
        this(name, description, LocalDate.parse(dueDate), isComplted);
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
