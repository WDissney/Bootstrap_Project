package ru.romanovdenis.bootstrap.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.romanovdenis.bootstrap.model.User;

import java.util.List;


public interface UserService extends UserDetailsService {

    List<User> getAllUsers();
    void addUser(User user);
    void removeUser(Long id);
    Object getUserId(Long id);

}
