package com.sivalabs.employees.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

record Employee(
        @NotEmpty(message = "Name is required")
        String name,
        @NotEmpty(message = "Email is required")
        @Email(message = "Invalid email")
        String email,
        @NotNull(message = "Salary is required")
        @Positive(message = "Salary must be positive")
        Double salary,
        String address) {
}
