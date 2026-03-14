package csa.sber.mapper;

import csa.sber.dto.credit.CreditRequestDTO;
import csa.sber.dto.credit.CreditResponseDTO;
import csa.sber.entity.Credit;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CreditMapper {

    @Mapping(target = "createdAt", ignore = true)
    CreditResponseDTO toDTO(Credit credit);

    @Mapping(target = "dealID", ignore = true)
    @Mapping(target = "dealNumber", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "payments", ignore = true)
    @Mapping(target = "schedule", ignore = true)
    Credit toEntity(CreditRequestDTO creditRequestDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "dealID", ignore = true)
    @Mapping(target = "dealNumber", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "payments", ignore = true)
    @Mapping(target = "schedule", ignore = true)
    void updateEntity(CreditRequestDTO creditRequestDTO, @MappingTarget Credit credit);
}