package com.sridharan.entityrelation.service;

import com.sridharan.entityrelation.model.Employee;
import com.sridharan.entityrelation.model.Manager;
import com.sridharan.entityrelation.model.Project;
import com.sridharan.entityrelation.repository.EmployeeRepository;
import com.sridharan.entityrelation.repository.ManagerRepository;
import com.sridharan.entityrelation.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ManagerRepository managerRepository;

    public Project createProject(Project project){
        log.info("Project with Id: {} is saved",project.getProjectId());
        return projectRepository.save(project);
    }
    public List<Project> getProjects(){
        log.info("Getting All Project");
        return projectRepository.findAll();
    }

    public Project getProjectById(long id){
        log.info("Getting Project with Id: {}", id);
        return projectRepository.findById(id).get();
    }

    public Project updateProject(Project project){
        Project OldProject = projectRepository.findById(project.getProjectId()).get();
        OldProject.setProjectName(project.getProjectName());
        log.info("Updating Project with Id: {}",project.getProjectId());
        return projectRepository.save(OldProject);
    }

    public String deleteProject(long id){
        projectRepository.deleteById(id);
        log.info("Deleting Project with Id: {}",id);
        return "Project Removed with id: "+id;
    }

    public Project enrollEmployeeToProject(long projectId,long employeeId){
        Project project = projectRepository.findById(projectId).get();
        Employee employee = employeeRepository.findById(employeeId).get();
        project.enrollEmployee(employee);
        log.info("Enrolling employee with Id: {} to Project with Id: {}",employeeId,projectId);
        return projectRepository.save(project);
    }

    public Project assignManagerToProject(long projectId,long managerId){
        Project project = projectRepository.findById(projectId).get();
        Manager manager = managerRepository.findById(managerId).get();
        project.assignManager(manager);
        log.info("Assigning Manager with Id: {} to Project with Id: {}",managerId,projectId);
        return projectRepository.save(project);
    }
}
