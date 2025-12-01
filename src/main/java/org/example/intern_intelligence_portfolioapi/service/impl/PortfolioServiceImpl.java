package org.example.intern_intelligence_portfolioapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.intern_intelligence_portfolioapi.dto.PortfolioCreateDto;
import org.example.intern_intelligence_portfolioapi.dto.PortfolioResponseDto;
import org.example.intern_intelligence_portfolioapi.dto.PortfolioUpdateDto;
import org.example.intern_intelligence_portfolioapi.entity.Portfolio;
import org.example.intern_intelligence_portfolioapi.exception.PortfolioNotFoundException;
import org.example.intern_intelligence_portfolioapi.mapper.PortfolioMapper;
import org.example.intern_intelligence_portfolioapi.repository.PortfolioRepository;
import org.example.intern_intelligence_portfolioapi.service.PortfolioService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioRepository portfolioRepository;

    private final PortfolioMapper portfolioMapper;

    @Override
    public PortfolioResponseDto create(PortfolioCreateDto dto, Long userId) {

        Portfolio entity = portfolioMapper.toEntity(dto);
        entity.setUserId(userId);
        entity = portfolioRepository.save(entity);
        return portfolioMapper.toDto(entity);
    }

    @Override
    public PortfolioResponseDto update(Long id, PortfolioUpdateDto dto, Long userId) {
        Portfolio entity = portfolioRepository.findById(id)
                .orElseThrow(() -> new PortfolioNotFoundException(" Portfolio Not Found "));
        if (!entity.getUserId().equals(userId)) {
            throw new RuntimeException("You do not have permission to edit this portfolio.");
        }
        portfolioMapper.updateEntity(dto, entity);
        portfolioRepository.save(entity);
        return portfolioMapper.toDto(entity);
    }

    @Override
    public PortfolioResponseDto getByUserId(Long userId) {
        Portfolio entity = portfolioRepository.findByUserId(userId)
                .orElseThrow(() -> new PortfolioNotFoundException("Portfolio not found for userId: " + userId));

        return portfolioMapper.toDto(entity);
    }

    @Override
    public PortfolioResponseDto getPortfolio(Long id) {
        Portfolio entity = portfolioRepository.findById(id)
                .orElseThrow(() -> new PortfolioNotFoundException("Requested portfolio does not exist. ID: " + id));

        return portfolioMapper.toDto(entity);
    }

    @Override
    public String delete(Long id, Long userId) {
        Portfolio entity = portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(""));
        if (!entity.getUserId().equals(userId)) {
            throw new RuntimeException("You do not have permission to delete this portfolio.");
        }
        portfolioRepository.delete(entity);
        return "Portfolio has been deleted";
    }
}
