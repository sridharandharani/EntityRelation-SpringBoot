package com.sridharan.entityrelation.repository;

import com.sridharan.entityrelation.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,Long> {
}
