package com.dl.MoneyApi.controllers;

import com.dl.MoneyApi.mappers.ExtratoMapper;
import com.dl.MoneyApi.models.Despesa;
import com.dl.MoneyApi.models.response.ResponsePadrao;
import com.dl.MoneyApi.services.DespesasServices;
import com.dl.MoneyApi.services.exceptions.FieldInvalidException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "Controller Extrato")
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class DespesaController {

    @Autowired
    DespesasServices despesasServices;

    private String pathCadastrarDespesa= "/cadastrar-nova-despesa";


    private final ExtratoMapper extratoMapper = ExtratoMapper.INSTANCE;

    //@ApiOperation(value = "Realiza o cadastro das ordens de compra dos produtos", notes = "Através desse endpoint é possível cadastrar as ordens de compra dos produtos", consumes = "application/json")
    @ApiOperation(value = "Retorna todas as Extratos")
    @PostMapping(value = "/cadastrar-nova-despesa", consumes = "application/json")
    public ResponseEntity<ResponsePadrao> cadastarNovaDespesa(@Valid @RequestBody Despesa despesa, BindingResult result){
        if(result.hasErrors()){
            throw new FieldInvalidException("Algum campo esta invalido.");
        }
        Despesa despesaAdd = despesasServices.cadastrarNovaDespesa(despesa);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponsePadrao(HttpStatus.OK.value(), "Registro cadastrado com sucesso!",pathCadastrarDespesa,despesaAdd));
    }


}
