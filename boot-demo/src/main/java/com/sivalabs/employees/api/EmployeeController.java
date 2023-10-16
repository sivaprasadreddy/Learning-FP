package com.sivalabs.employees.api;

import com.sivalabs.employees.domain.EmployeeService;
import com.sivalabs.employees.domain.EmployeesPayload;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EmployeeController {
    private final EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/api/employees/import")
    void importEmployees(@RequestBody @Valid EmployeesPayload employeesPayload) {
        employeeService.importEmployees(employeesPayload);
    }
}
