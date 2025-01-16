package com.SpringBoot2025_W2.services;

import com.SpringBoot2025_W2.dto.EmployeeDTO;
import com.SpringBoot2025_W2.entities.EmployeeEntity;
import com.SpringBoot2025_W2.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService
{
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper)
    {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id)
{
    EmployeeEntity employeeEntity=employeeRepository.findById(id).orElse(null);
    return modelMapper.map(employeeEntity, EmployeeDTO.class);
}

    public List<EmployeeDTO> getAllEmployee()
    {
        List<EmployeeEntity> employeeEntities=employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee)
    {
        EmployeeEntity toSaveEntity=modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity=employeeRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }
    public EmployeeDTO updateEmployeeById(Long id,EmployeeDTO employeeDTO)
    {
        EmployeeEntity employeeEntity=modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setId(id);
        EmployeeEntity savedEmployeeEntity=employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }
    public boolean deleteEmployeeById(Long id)
    {
        if(employeeRepository.existsById(id)==false)
            return false;

    employeeRepository.deleteById(id);
    return true;
    }
}
