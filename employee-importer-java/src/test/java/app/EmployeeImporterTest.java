package app;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeImporterTest {
    EmployeeImporter employeeImporter = new EmployeeImporter();

    @Test
    void importEmployeesWithValidFile() {
        var response = employeeImporter.importEmployees("valid-file.json");
        assertThat(response.status()).isEqualTo("success");
        assertThat(response.message()).isEqualTo("Imported successfully");

        var employees = EmployeeRepository.getInstance().findAll();
        var john = new Employee("John", "john@gmail.com", 10000.0, "Hyderabad");
        var jane = new Employee("Jane", "jane@gmail.com", 20000.0, null);

        assertThat(employees).contains(john, jane);
    }

    @Test
    void importEmployeesWithInvalidFile() {
        var response = employeeImporter.importEmployees("invalid-file.json");
        assertThat(response.status()).isEqualTo("error");
        assertThat(response.message()).isEqualTo("Invalid data");
    }

    @Test
    void importEmployeesWithNonExistingFile() {
        var response = employeeImporter.importEmployees("non-existing-file.json");
        assertThat(response.status()).isEqualTo("error");
        assertThat(response.message()).isEqualTo("Internal Server Error");
    }
}