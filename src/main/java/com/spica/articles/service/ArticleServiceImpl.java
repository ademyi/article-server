package com.spica.articles.service;

import com.spica.articles.dto.DetailedSearchResponse;
import com.spica.articles.dto.SearchResponse;
import com.spica.articles.model.Article;
import com.spica.articles.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService{

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<SearchResponse> searchArticle(String searchTitle){
        var response = articleRepository.findArticleByTitleContainsIgnoreCase(searchTitle);
        return convertArticleDto(response);
    }

    private List<SearchResponse> convertArticleDto(List<Article> response) {
        var result = new ArrayList<SearchResponse>();
        if (response != null){
            result = (ArrayList<SearchResponse>) response.stream()
                    .map(this::convertSearchResponse)
                    .collect(Collectors.toList());

        }
        return result;
    }


    public SearchResponse convertSearchResponse(Article e) {
        var article = new SearchResponse();
        article.setHours(e.getHours());
        article.setTitle(e.getTitle());
        return article;
    }

    @Override
    public DetailedSearchResponse searchArticleInDetail(String searchTitle){
        var result = new DetailedSearchResponse(0.0, null);
        var searchResults = searchArticle(searchTitle);

        if ( searchResults != null && !searchResults.isEmpty()) {
            var totalHours = searchResults.stream()
                    .mapToDouble( e -> e.getHours()).sum();

            result.setTotalHours(totalHours);
            result.setArticles(searchResults);
        }
        return result;
    }

}
