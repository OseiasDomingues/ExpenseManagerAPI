package com.dl.MoneyApi.config;


import com.dl.MoneyApi.models.Despesa;
import com.dl.MoneyApi.models.Extrato;
import com.dl.MoneyApi.repositories.DespesasRepository;
import com.dl.MoneyApi.repositories.ExtratoRepository;
import com.dl.MoneyApi.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    ExtratoRepository extratoRepository;
    @Autowired
    DespesasRepository despesasRepository;

    @PostConstruct
    public void mock() {

        List<Despesa> despesas = new ArrayList<>();
        Despesa d1 = new Despesa(null, "Recarga 01","Saldo Disponivel","Casa & Saúde", null, LocalDate.of( 2022, 7,  11),"15.00" );
        Despesa d2 = new Despesa(null, "Recarga 02","Saldo Disponivel","Casa & Saúde", null, LocalDate.of( 2022, 8,  20),"15.00" );
        Despesa d3 = new Despesa(null, "Recarga 03","Saldo Disponivel","Casa & Saúde", null,null,"15.00" );

        despesas.addAll(Arrays.asList(d1,d2,d3));

        despesasRepository.saveAll(Arrays.asList(d1,d2,d3));

        Extrato extrato = new Extrato(null, 2022, 3,despesas );

        extratoRepository.save(extrato);
    }
}
