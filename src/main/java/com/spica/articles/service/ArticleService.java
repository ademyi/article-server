package com.spica.articles.service;

import com.spica.articles.dto.DetailedSearchResponse;
import com.spica.articles.dto.SearchResponse;
import com.spica.articles.model.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    List<SearchResponse> searchArticle(String searchTitle);

    DetailedSearchResponse searchArticleInDetail(String searchTitle);
}
