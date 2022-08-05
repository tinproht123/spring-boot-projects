package net.spring.springjwt;

import net.spring.springjwt.models.Role;
import net.spring.springjwt.models.User;
import net.spring.springjwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "USER"));
			userService.saveRole(new Role(null, "ADMIN"));
			userService.saveRole(new Role(null, "MANAGER"));
			userService.saveRole(new Role(null, "SUPER_IDOL"));

			userService.saveUser(new User(null, "Minh Anh", "minhanh123", "closer123", new ArrayList<>()));
			userService.saveUser(new User(null, "Nguyen Dat", "dat123", "dat123", new ArrayList<>()));
			userService.saveUser(new User(null, "Van Huan", "huan123", "huan123", new ArrayList<>()));

			userService.addRoleToUser("minhanh123", "ADMIN");
			userService.addRoleToUser("minhanh123", "SUPER_IDOL");
			userService.addRoleToUser("minhanh123", "MANAGER");
			userService.addRoleToUser("dat123", "USER");
			userService.addRoleToUser("huan123", "USER");
		};
	}
}
