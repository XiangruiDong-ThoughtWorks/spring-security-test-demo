package com.example.repository;

import com.example.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserByUsername(String username);

    @Secured("ADMIN")
    @Override
    <S extends User> S save(S s);
}
