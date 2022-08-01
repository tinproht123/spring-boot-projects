package net.spring.springbootbackend.controllers;

import net.spring.springbootbackend.exception.ResourceNotFoundException;
import net.spring.springbootbackend.models.Employee;
import net.spring.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        return ResponseEntity.ok().body(employee);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee updatedEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        updatedEmployee.setFirstName(employeeDetails.getFirstName());
        updatedEmployee.setLastName(employeeDetails.getLastName());
        updatedEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updatedEmployee);

        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
