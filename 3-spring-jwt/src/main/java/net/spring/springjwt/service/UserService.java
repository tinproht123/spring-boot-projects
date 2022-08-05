package net.spring.springjwt.service;

import net.spring.springjwt.models.Role;
import net.spring.springjwt.models.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getAllUsers();
}
