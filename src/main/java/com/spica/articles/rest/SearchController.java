package com.spica.articles.rest;

import com.spica.articles.dto.DetailedSearchResponse;
import com.spica.articles.dto.SearchResponse;
import com.spica.articles.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController {

    private final ArticleService articleService;

    @Autowired
    public SearchController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/search")
    public List<SearchResponse> simpleSearch(@RequestParam String title){
        return articleService.searchArticle(title);
    }

    @GetMapping("/search/detailed")
    public DetailedSearchResponse detailedSearch(@RequestParam String title){
        return articleService.searchArticleInDetail(title);
    }

}
