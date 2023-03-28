package com.sridharan.entityrelation.repository;

import com.sridharan.entityrelation.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
