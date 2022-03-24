package com.dl.MoneyApi.services.impl;

import com.dl.MoneyApi.models.Despesa;
import com.dl.MoneyApi.models.Extrato;
import com.dl.MoneyApi.repositories.DespesasRepository;
import com.dl.MoneyApi.repositories.ExtratoRepository;
import com.dl.MoneyApi.services.DespesasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class DespesaServicesImpl implements DespesasServices {

    @Autowired
    DespesasRepository despesasRepository;
    @Autowired
    ExtratoRepository extratoRepository;

    @Override
    public Despesa cadastrarNovaDespesa(Despesa despesa) {
        Despesa novaDespesa = despesasRepository.save(despesa);
        Extrato extrato = retornarExtrato(novaDespesa.getDate());
        despesasRepository.salvarEmExtrato(extrato.getId(),novaDespesa.getId());
        return novaDespesa;
    }

    private Extrato retornarExtrato(String dateDespesaNova) {
        LocalDate localDateDespesaNova = LocalDate.parse(dateDespesaNova, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int ano = localDateDespesaNova.getYear();
        int mes = localDateDespesaNova.getMonthValue();
        return extratoRepository.buscarPorData(ano,mes);
    }
}
