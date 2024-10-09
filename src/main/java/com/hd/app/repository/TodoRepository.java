package com.hd.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hd.app.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
