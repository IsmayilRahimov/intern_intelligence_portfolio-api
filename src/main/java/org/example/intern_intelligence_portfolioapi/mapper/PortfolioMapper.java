package org.example.intern_intelligence_portfolioapi.mapper;

import org.example.intern_intelligence_portfolioapi.dto.PortfolioCreateDto;
import org.example.intern_intelligence_portfolioapi.dto.PortfolioResponseDto;
import org.example.intern_intelligence_portfolioapi.dto.PortfolioUpdateDto;
import org.example.intern_intelligence_portfolioapi.entity.Portfolio;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PortfolioMapper {

    Portfolio toEntity(PortfolioCreateDto dto);

    PortfolioResponseDto toDto(Portfolio entity);

    void updateEntity(PortfolioUpdateDto dto, @MappingTarget Portfolio entity);

}
