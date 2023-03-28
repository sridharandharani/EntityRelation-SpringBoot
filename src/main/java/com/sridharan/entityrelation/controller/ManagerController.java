package com.sridharan.entityrelation.controller;

import com.sridharan.entityrelation.model.Manager;
import com.sridharan.entityrelation.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ManagerController {

    @Autowired
    private ManagerService service;

    @PostMapping("/addmanager")
    public Manager addManager(@RequestBody Manager manager){
        log.info("Inside Manager Added");
        return service.createManager(manager);
    }
    @GetMapping("/managers")
    public List<Manager> getAllManager(){
        log.info("Inside Get all Managers");
        return service.getManagers();
    }

    @GetMapping("/manager/{id}")
    public Manager getManagerById(@PathVariable long id){
        log.info("Inside Get Manager with id");
        return service.getManagerById(id);
    }

    @PutMapping("/updatemanager/{id}")
    public Manager updateManager(@PathVariable long id, @RequestBody Manager manager){
        log.info("Inside Update the Manager");
        manager.setManagerId(id);
        return service.updateManager(manager);
    }

    @DeleteMapping("/deletemanager/{id}")
    public String deleteManager(@PathVariable long id){
        log.info("Inside Delete Manager");
        return service.deleteManager(id);
    }
}
