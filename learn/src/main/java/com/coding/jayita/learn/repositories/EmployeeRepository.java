package com.coding.jayita.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coding.jayita.learn.entities.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>
{
 //With JPA no need to write SQL query, only in complex cases need to
    
}