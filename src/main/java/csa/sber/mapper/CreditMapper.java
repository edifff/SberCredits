package csa.sber.mapper;

import csa.sber.dto.CreditReqestDTO;
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
    Credit toEntity(CreditReqestDTO creditReqestDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "dealID", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updateAt", ignore = true)
    @Mapping(target = "payments", ignore = true)
    void updateEntity(CreditReqestDTO creditReqestDTO, @MappingTarget Credit credit);
}