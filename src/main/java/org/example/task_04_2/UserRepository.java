package org.example.task_04_2;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {
    @Query("select user from User user where user.id = ?1")
    User view(Long userId);

    @Query("select user From User user")
    List<User> viewAll();



}
