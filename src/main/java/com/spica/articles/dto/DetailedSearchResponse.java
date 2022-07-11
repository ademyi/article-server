package com.spica.articles.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DetailedSearchResponse {
    private Double totalHours;
    private List<SearchResponse> articles;
}
