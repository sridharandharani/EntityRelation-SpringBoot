package com.sridharan.entityrelation.controller;

import com.sridharan.entityrelation.model.Project;
import com.sridharan.entityrelation.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ProjectController {

    @Autowired
    private ProjectService service;

    @PostMapping("/addproject")
    public Project addProject(@RequestBody Project project){
        log.info("Inside Project Added");
        return service.createProject(project);
    }
    @GetMapping("/projects")
    public List<Project> getAllProject(){
        log.info("Inside Get all Projects");
        return service.getProjects();
    }

    @GetMapping("/project/{id}")
    public Project getProjectById(@PathVariable long id){
        log.info("Inside Get Project with id");
        return service.getProjectById(id);
    }

    @PutMapping("/updateproject/{id}")
    public Project updateProject(@PathVariable long id, @RequestBody Project project){
        log.info("Inside Update the Project");
        project.setProjectId(id);
        return service.updateProject(project);
    }

    @DeleteMapping("/deleteproject/{id}")
    public String deleteProject(@PathVariable long id){
        log.info("Inside Delete Project");
        return service.deleteProject(id);
    }

    @PutMapping("/{projectId}/employee/{employeeId}")
    public Project enrollEmployeeToProject(@PathVariable long projectId, @PathVariable long employeeId){
        log.info("Inside Enroll Employee To a Project");
        return service.enrollEmployeeToProject(projectId,employeeId);
    }

    @PutMapping("/{projectId}/manager/{managerId}")
    public Project assignManagerToProject(@PathVariable long projectId, @PathVariable long managerId){
        log.info("Inside Assign Manager to a Project");
        return service.assignManagerToProject(projectId,managerId);
    }

}
