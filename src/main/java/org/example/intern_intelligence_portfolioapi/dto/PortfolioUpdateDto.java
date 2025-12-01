package org.example.intern_intelligence_portfolioapi.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class PortfolioUpdateDto {

    private String fullName;
    @Column(columnDefinition = "TEXT")
    private String about;
    private List<String> skills;
    private List<String> projects;
    private List<String> experience;
    private List<String> education;
}
