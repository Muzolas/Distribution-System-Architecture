package com.example.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app.model.Task;

/*
 * 
 *  Task varlığı için veri erişim işlemlerini yöneten bir JPA repository arayüzüdür.
 * 
*/
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
} 