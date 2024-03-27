package org.example.task_04_2;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ArticleRepository extends CrudRepository<Article,Long> {


    @Query("SELECT article from Article article WHERE article.id=?1")
    Article view(Long articleId);

    @Query("select article From Article article")
    List<Article> viewAll();
}
