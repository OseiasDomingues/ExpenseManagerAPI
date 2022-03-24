package com.dl.MoneyApi.mappers;

import com.dl.MoneyApi.models.Extrato;
import com.dl.MoneyApi.models.request.ExtratoRequest;
import com.dl.MoneyApi.models.response.ExtratoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExtratoMapper {


    ExtratoMapper INSTANCE = Mappers.getMapper(ExtratoMapper.class);

    ExtratoRequest toDTO(Extrato Extrato);

    ExtratoResponse toResponse(Extrato Extrato);
}
