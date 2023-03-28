package com.sridharan.entityrelation.repository;

import com.sridharan.entityrelation.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
