package com.dl.MoneyApi.controllers;

import com.dl.MoneyApi.mappers.ExtratoMapper;
import com.dl.MoneyApi.models.Extrato;
import com.dl.MoneyApi.models.request.ExtratoRequest;
import com.dl.MoneyApi.models.response.ExtratoResponse;
import com.dl.MoneyApi.models.response.ResponsePadrao;
import com.dl.MoneyApi.services.ExtratoServices;
import com.dl.MoneyApi.services.exceptions.FieldInvalidException;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Extrato", description = "Operações referentes ao extrato")
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ExtratoController {

    @Autowired
    ExtratoServices extratoServices;

    private String pathBuscarExtrato = "/buscar-extrato-por-data";


    private final ExtratoMapper extratoMapper = ExtratoMapper.INSTANCE;

    @ApiOperation(value = "Retorna os extrato por data")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma mensagem de sucesso padrão", response = ResponsePadrao.class),
            @ApiResponse(code = 400, message = "Parâmetros Inválidos", response = ResponsePadrao.class),
            @ApiResponse(code = 500, message = "Erro do servidor", response = ResponsePadrao.class),
    })
    @PostMapping(value = "/buscar-extrato-por-data", consumes = "application/json")
    public ResponseEntity<ResponsePadrao> buscarExtratoPorData(@Valid @RequestBody @ApiParam(name = "Extrato ano/mês", value = "Extrato ano/mês") ExtratoRequest extratoRequest, BindingResult result){
        if(result.hasErrors()){
            throw new FieldInvalidException("Algum campo esta invalido.");
        }
        Extrato extrato = extratoServices.buscarPorData(extratoRequest.getAno(), extratoRequest.getMes());
        ExtratoResponse ExtratoResponses = extratoMapper.toResponse(extrato);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponsePadrao(HttpStatus.OK.value(), "Registro cadastrado com sucesso!",pathBuscarExtrato,ExtratoResponses));
    }


}
