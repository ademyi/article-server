package com.spica.articles.repo;

import com.spica.articles.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findArticleByTitleContainsIgnoreCase(String search);
}
