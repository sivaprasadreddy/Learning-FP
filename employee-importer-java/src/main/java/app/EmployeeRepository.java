package app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

class EmployeeRepository {
    private static final Map<Long, EmployeeEntity> TABLE = new HashMap<>();
    private static final AtomicLong ID_GENERATOR = new AtomicLong(0);
    private static final EmployeeRepository INSTANCE = new EmployeeRepository();

    private EmployeeRepository() {
    }

    public static EmployeeRepository getInstance() {
        return INSTANCE;
    }

    public void create(Employee employee) {
        Long id = ID_GENERATOR.incrementAndGet();
        EmployeeEntity employeeEntity = new EmployeeEntity(id, employee.name(), employee.email(), employee.salary(), employee.address());
        TABLE.put(id, employeeEntity);
    }

    public void update(Employee employee) {
        TABLE.values().stream()
                .filter(e -> e.email().equalsIgnoreCase(employee.email()))
                .findFirst()
                .ifPresent(e -> TABLE.put(e.id(),
                        new EmployeeEntity(e.id(), employee.name(), employee.email(), employee.salary(), employee.address())));
    }

    public boolean existByEmail(String email) {
        return TABLE.values().stream().anyMatch(e -> e.email().equalsIgnoreCase(email));
    }

    public List<Employee> findAll() {
        return TABLE.values().stream().map(this::toEmployee).toList();
    }

    private Employee toEmployee(EmployeeEntity entity) {
        return new Employee(entity.name(), entity.email(), entity.salary(), entity.address());
    }
}
