package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    @Autowired
    private DbService service;
    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET,value = "getTasks")
    public List<TaskDto> getTasks(){

        return taskMapper.mapToTaskDtoList(service.getAllTasks());
    }
    @RequestMapping(method = RequestMethod.GET,value = "getTask")
    public TaskDto getTask(@RequestParam Long taskId)throws TaskNotFoundException{
        return taskMapper.mapToTaskDto(service.findById(taskId).orElseThrow(TaskNotFoundException::new));
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
    public void deleteTask(@RequestParam Long taskId){}

    @RequestMapping(method = RequestMethod.POST, value = "updateTask")
    public TaskDto updateTask(@RequestBody TaskDto taskDto){
        return new TaskDto(1L, "Edited test title", "Test content");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTask")
    public void createTask(@RequestBody TaskDto taskDto){}
}
