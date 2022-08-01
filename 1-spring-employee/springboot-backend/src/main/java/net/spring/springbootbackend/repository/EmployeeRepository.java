package net.spring.springbootbackend.repository;

import net.spring.springbootbackend.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
