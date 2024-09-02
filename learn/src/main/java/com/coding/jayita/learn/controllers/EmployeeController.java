package com.coding.jayita.learn.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coding.jayita.learn.dto.EmployeeDTO;
import com.coding.jayita.learn.services.EmployeeService;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;




@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    //it's object will passed automatically

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{id}") //Passing id is mandatory field
    public EmployeeDTO getEmployeeById(@PathVariable("id") Long employeeId) {
        //return new EmployeeDTO(employeeId, "Jayita", LocalDate.of(2024, 02, 20), true);
        return employeeService.getEmployeeById(employeeId);
    }
    
    @GetMapping() //sortBy,limit optional fields ?sortBy=kuchbhi&limit=10 but if mention need to metion both
    public String getAllEmployee( @PathParam("sortBy") String sortBy, @PathParam("limit") int limit) 
    {
        return "Hello "+ sortBy+" "+limit;
    }

    @GetMapping(path = "/all")
    public List<EmployeeDTO> getEmployees() {
        return employeeService.getAll();
    }
    

    @PostMapping(path = "/add")
    public EmployeeDTO postMethodName(@RequestBody EmployeeDTO employeeDTO) {
        return employeeService.createNewEmployee(employeeDTO);
        // return "Employee Added!!";
    }
    
    @DeleteMapping(path = "/{id}")
    public boolean deleteEmployeeById(@PathVariable Long id){
        return employeeService.deleteEmployeeById(id);
    }
    
    
}
