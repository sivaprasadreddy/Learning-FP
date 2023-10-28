package app;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class EmployeeImporter {
    private final EmployeeRepository repo;

    public EmployeeImporter() {
        this.repo = EmployeeRepository.getInstance();
    }

    public Response importEmployees(String filePath) {
        try {
            EmployeesImportPayload payload = parseInputFile(filePath);
            if (!payload.isValid()) {
                return new Response("error", "Invalid data");
            }
            payload.employees().forEach(this::saveOrUpdate);
            return new Response("success", "Imported successfully");
        } catch (Exception e) {
            return new Response("error", "Internal Server Error");
        }
    }

    private EmployeesImportPayload parseInputFile(String filePath) throws IOException {
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(filePath)) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(is, EmployeesImportPayload.class);
        }
    }

    private void saveOrUpdate(Employee employee) {
        if(repo.existByEmail(employee.email())) {
            repo.update(employee);
        } else {
            repo.create(employee);
        }
    }

    public record Response(String status, String message) { }
}
