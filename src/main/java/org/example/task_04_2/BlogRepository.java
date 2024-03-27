package org.example.task_04_2;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BlogRepository extends CrudRepository<Blog,Long> {
    @Query("SELECT blog from Blog blog WHERE blog.id=?1")
    Blog view(Long blogId);

    @Query("select blog from Blog blog")
    List<Blog> viewAll();


}
