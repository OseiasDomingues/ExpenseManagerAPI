package com.dl.MoneyApi.services;

import com.dl.MoneyApi.models.Extrato;

import java.util.List;


public interface ExtratoServices {

    Extrato buscarPorData(Integer ano, Integer mes);

}
