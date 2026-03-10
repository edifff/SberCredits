package csa.sber.mapper;

import csa.sber.dto.CreditRequestDTO;
import csa.sber.dto.CreditResponseDTO;
import csa.sber.entity.Credit;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CreditMapper {

    @Mapping(target = "createdAt", ignore = true)
    CreditResponseDTO toDTO(Credit credit);

    @Mapping(target = "dealID", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    @Mapping(target = "payments", ignore = true)
    Credit toEntity(CreditRequestDTO creditRequestDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "dealID", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    @Mapping(target = "payments", ignore = true)
    void updateEntity(CreditRequestDTO creditRequestDTO, @MappingTarget Credit credit);
}