package org.example.intern_intelligence_portfolioapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class PortfolioResponseDto {

    private Long id;
    private Long userId;

    private String fullName;
    private String about;

    private List<String> skills;
    private List<String> projects;
    private List<String> experience;
    private List<String> education;
}
