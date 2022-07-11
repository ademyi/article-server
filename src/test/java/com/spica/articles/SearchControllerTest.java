package com.spica.articles;

import com.spica.articles.dto.DetailedSearchResponse;
import com.spica.articles.dto.SearchResponse;
import com.spica.articles.model.Article;
import com.spica.articles.repo.ArticleRepository;
import com.spica.articles.rest.SearchController;
import com.spica.articles.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SearchController.class)
public class SearchControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ArticleRepository articleRepository;

    @MockBean
    ArticleService articleService;

    SearchResponse response1 = new SearchResponse(2.5, "Quick tips 1");
    SearchResponse response2 = new SearchResponse(3.5, "Quick tips 2");

    @Test
    public void searchByTerm_success() throws Exception{
        var responses = new ArrayList<>(Arrays.asList(response1, response2));

        Mockito.when(articleService.searchArticle(anyString())).thenReturn(responses);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/search?title=tips")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void searchDetailed_success() throws Exception{

        var responses = new ArrayList<>(Arrays.asList(response1, response2));
        var detailed = new DetailedSearchResponse(6.0, responses);


        Mockito.when(articleService.searchArticleInDetail(anyString())).thenReturn(detailed);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/search/detailed?title=tips")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("totalHours", is(6.0)));
    }

}
