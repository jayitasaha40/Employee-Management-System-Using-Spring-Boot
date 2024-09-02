package com.coding.jayita.learn.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.coding.jayita.learn.dto.EmployeeDTO;
import com.coding.jayita.learn.entities.EmployeeEntity;
import com.coding.jayita.learn.repositories.EmployeeRepository;
import java.util.*;
import java.util.stream.Collectors;

@Service //Automatically Bean will be created
public class EmployeeService {
    
    final EmployeeRepository employeeRepository;
    final ModelMapper modelmapper;


    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper)
    {
        this.employeeRepository = employeeRepository;
        this.modelmapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id)
    {
        EmployeeEntity employeeEntity = employeeRepository.getReferenceById(id);
        //return new EmployeeDTO(employeeEntity.getId(),employeeEntity.getName(),employeeEntity.getDateOfJoining(),employeeEntity.isActive());
        return modelmapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelmapper.map(employeeDTO,EmployeeEntity.class);
        return modelmapper.map( employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAll(){
        return employeeRepository
        .findAll()
        .stream()
        .map(employeeEntity -> modelmapper.map(employeeEntity,EmployeeDTO.class))
        .collect(Collectors.toList());
    }

    public boolean deleteEmployeeById(Long id) {
        boolean isPresent = employeeRepository.existsById(id);
        if(!isPresent) return false;
        employeeRepository.deleteById(id);
        return true;
    }
}
