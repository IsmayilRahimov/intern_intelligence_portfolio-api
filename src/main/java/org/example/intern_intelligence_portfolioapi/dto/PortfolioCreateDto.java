package org.example.intern_intelligence_portfolioapi.dto;


import lombok.Data;

import java.util.List;

@Data
public class PortfolioCreateDto {

    private String fullName;
    private String about;


    private String description;

    private List<String> skills;
    private List<String> projects;
    private List<String> experience;
    private List<String> education;
}
