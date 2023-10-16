package com.sivalabs.employees.domain;

import jakarta.validation.Valid;

import java.util.List;

public record EmployeesPayload(@Valid List<Employee> employees) {
}
