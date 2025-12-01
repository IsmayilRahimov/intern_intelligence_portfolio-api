package org.example.intern_intelligence_portfolioapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "user_portfolio")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(columnDefinition = "TEXT")
    private String about;

    @ElementCollection
    private List<String> skills;

    @ElementCollection
    private List<String> projects;

    @ElementCollection
    private List<String> experience;

    @ElementCollection
    private List<String> education;
}
