package org.example.task_04_2;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role,Long> {
    @Query("select role from Role role where role.id = ?1")
    Role view(Long roleId);
    @Query("select role from Role role")
    List<Role> viewAll();


}
