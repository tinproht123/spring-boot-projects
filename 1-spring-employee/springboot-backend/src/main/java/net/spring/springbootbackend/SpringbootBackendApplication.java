package net.spring.springbootbackend;

import net.spring.springbootbackend.models.Employee;
import net.spring.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		/*Employee employee = new Employee();
		employee.setFirstName("Nguyen");
		employee.setLastName("Minh Anh");
		employee.setEmailId("tinproht123@gmail.com");
		employeeRepository.save(employee);*/
	}
}
