package ru.kata.spring.boot_security.demo.init;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class InitializerUserRole {
    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    public InitializerUserRole(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @PostConstruct
    private void postConstruct() {
        Role roleAdmin = new Role((long)1,"ADMIN");
        Role roleUser = new Role( (long)2,"USER");
        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        User admin = new User("admin@gmail.com", "admin", "admin", "admin", 28, Set.of(roleAdmin, roleUser));
        User user = new User("user@gmail.com", "user", "user", "user", 37, Set.of(roleUser));
        userService.addUser(admin);
        userService.addUser(user);
    }
}

