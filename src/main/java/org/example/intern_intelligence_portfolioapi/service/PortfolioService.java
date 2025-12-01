package org.example.intern_intelligence_portfolioapi.service;

import org.example.intern_intelligence_portfolioapi.dto.PortfolioCreateDto;
import org.example.intern_intelligence_portfolioapi.dto.PortfolioResponseDto;
import org.example.intern_intelligence_portfolioapi.dto.PortfolioUpdateDto;

public interface PortfolioService {

    PortfolioResponseDto create(PortfolioCreateDto dto, Long userId);

    PortfolioResponseDto update(Long id, PortfolioUpdateDto dto, Long userId);

    PortfolioResponseDto getByUserId(Long userId);

    PortfolioResponseDto getPortfolio(Long id);

    String delete(Long id, Long userId);
}
