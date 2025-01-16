package com.SpringBoot2025_W2.controllers;

import com.SpringBoot2025_W2.dto.EmployeeDTO;
import com.SpringBoot2025_W2.entities.EmployeeEntity;
import com.SpringBoot2025_W2.exceptions.ResourceNotFoundException;
import com.SpringBoot2025_W2.repositories.EmployeeRepository;
import com.SpringBoot2025_W2.services.EmployeeService;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController
{
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

//    @GetMapping(path = "/{employeeId}")
//    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long Id)
//    {
//            EmployeeDTO employeeDTO = employeeService.getEmployeeById(Id);
//            return ResponseEntity.ok(employeeDTO);
//
//    }
    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long Id) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(Id);
        if (employeeDTO == null) {
            throw new ResourceNotFoundException("Employee not found with ID: " + Id);
        }
        return ResponseEntity.ok(employeeDTO);
    }


    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees()
    {
        if(employeeService.getAllEmployee().size()==0)
        {
            throw new ResourceNotFoundException("Not Found Bro");
        }
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee)
    {
       EmployeeDTO employeeDTO=employeeService.createNewEmployee(inputEmployee);
       return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO,@PathVariable Long id)
    {
        return ResponseEntity.ok(employeeService.updateEmployeeById(id,employeeDTO));
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long id)
    {
        boolean del=employeeService.deleteEmployeeById(id);
        if(del==true)
            return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }
}
