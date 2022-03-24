package com.dl.MoneyApi.services.impl;

import com.dl.MoneyApi.models.Despesa;
import com.dl.MoneyApi.models.Extrato;
import com.dl.MoneyApi.repositories.ExtratoRepository;
import com.dl.MoneyApi.services.ExtratoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ExtratoServicesImpl implements ExtratoServices {

    @Autowired
    ExtratoRepository extratoRepository;

    @Override
    public Extrato buscarPorData(Integer ano, Integer mes) {
        Extrato extrato = extratoRepository.buscarPorData(ano, mes);
        extrato.setTotalForCalc(new BigDecimal(0));
        for (Despesa d : extrato.getDespesas()){
            extrato.setTotalForCalc(extrato.getTotalForCalc().add(d.getValorForCalc()));
        }
        return extrato;
    }



}
