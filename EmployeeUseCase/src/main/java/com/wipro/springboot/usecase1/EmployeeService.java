package com.wipro.springboot.usecase1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final Map<Long, Employee> employeeMap = new HashMap<>();
    private long idCounter = 1;
    
    // Use HashSet for quick role validation
    private static final Set<String> VALID_ROLES = new HashSet<>();
    
    static {
        VALID_ROLES.add("Developer");
        VALID_ROLES.add("Tester");
        VALID_ROLES.add("Architect");
    }

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeMap.values()); // Fetch from HashMap
    }

    public Employee addEmployee(Employee employee) {
        // Validate Role
        if (!VALID_ROLES.contains(employee.getRole())) {
            throw new IllegalArgumentException("Invalid role! Allowed roles: Developer, Tester, Architect");
        }
        
        employee.setId(idCounter++); // Assign unique ID
        employeeMap.put(employee.getId(), employee); // Store in HashMap
        return employeeRepository.save(employee); // Store in DB
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return Optional.ofNullable(employeeMap.get(id));
    }

    public void deleteEmployee(Long id) {
        employeeMap.remove(id);
        employeeRepository.deleteById(id);
    }
}