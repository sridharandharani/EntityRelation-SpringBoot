package com.sridharan.entityrelation.service;

import com.sridharan.entityrelation.model.Manager;
import com.sridharan.entityrelation.repository.ManagerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public Manager createManager(Manager manager){
        log.info("Manager with Id: {} is saved",manager.getManagerId());
        return managerRepository.save(manager);
    }
    public List<Manager> getManagers(){
        log.info("Getting All Manager");
        return managerRepository.findAll();
    }

    public Manager getManagerById(long id){
        log.info("Getting Manager with Id: {}", id);
        return managerRepository.findById(id).get();
    }

    public Manager updateManager(Manager manager){
        Manager OldManager = managerRepository.findById(manager.getManagerId()).get();
        OldManager.setManagerName(manager.getManagerName());
        log.info("Updating employee with Id: {}",manager.getManagerId());
        return managerRepository.save(OldManager);
    }

    public String deleteManager(long id){
        managerRepository.deleteById(id);
        log.info("Deleting Manager with Id: {}",id);
        return "Manager Removed with id: "+id;
    }
}
