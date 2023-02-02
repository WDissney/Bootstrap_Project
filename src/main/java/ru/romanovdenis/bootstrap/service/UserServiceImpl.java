package ru.romanovdenis.bootstrap.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.romanovdenis.bootstrap.model.User;
import ru.romanovdenis.bootstrap.repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @Override
    @Transactional
    public void removeUser(Long id){
        userRepository.deleteById(id);
    }
    @Override
    @Transactional
    public void addUser (User user){
        userRepository.save(user);
    }
    @Override
    public Object getUserId(Long id){
       return userRepository.getById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserName(username);
        if(user == null)
            throw new UsernameNotFoundException("User not found");
        return user;
    }
}
