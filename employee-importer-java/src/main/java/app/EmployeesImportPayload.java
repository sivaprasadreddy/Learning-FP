package app;

import java.util.List;

record EmployeesImportPayload(List<Employee> employees) {
    public boolean isValid() {
        return employees.stream().allMatch(Employee::isValid);
    }
}
