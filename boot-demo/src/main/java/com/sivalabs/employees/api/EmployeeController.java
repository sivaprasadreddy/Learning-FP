package com.sivalabs.employees.api;

import com.sivalabs.employees.domain.EmployeeService;
import com.sivalabs.employees.domain.EmployeesPayload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EmployeeController {
    private final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/api/employees/import")
    void importEmployees(EmployeesPayload employeesPayload) {
        employeeService.importEmployees(employeesPayload);
    }
}
