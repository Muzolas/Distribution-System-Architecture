package com.example.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.app.model.Task;
import com.example.app.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Cacheable(value = "tasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Cacheable(value = "task", key = "#id")
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @CacheEvict(value = {"tasks", "task"}, allEntries = true)
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @CacheEvict(value = {"tasks", "task"}, allEntries = true)
    public Optional<Task> updateTask(Long id, Task taskDetails) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            Task existingTask = task.get();
            existingTask.setTitle(taskDetails.getTitle());
            existingTask.setDescription(taskDetails.getDescription());
            existingTask.setCompleted(taskDetails.isCompleted());
            return Optional.of(taskRepository.save(existingTask));
        }
        return Optional.empty();
    }

    @CacheEvict(value = {"tasks", "task"}, allEntries = true)
    public boolean deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
} 