package com.sivalabs.employees.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void importEmployees(EmployeesPayload employeesPayload) {
        employeesPayload.employees().forEach(this::importEmployee);
    }

    private void importEmployee(Employee employee) {
        Optional<EmployeeEntity> employeeOptional = employeeRepository.findByEmail(employee.email());
        EmployeeEntity employeeEntity;
        if (employeeOptional.isPresent()) {
            employeeEntity = employeeOptional.get();
            employeeEntity.setName(employee.name());
            employeeEntity.setSalary(employee.salary());
            employeeEntity.setAddress(employee.address());
        } else {
            employeeEntity = new EmployeeEntity(null, employee.name(), employee.email(), employee.salary(), employee.address());
        }
        employeeRepository.save(employeeEntity);
    }
}
