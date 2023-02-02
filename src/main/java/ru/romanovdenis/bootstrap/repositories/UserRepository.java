package ru.romanovdenis.bootstrap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.romanovdenis.bootstrap.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    User findUserByUserName(String name);

}
