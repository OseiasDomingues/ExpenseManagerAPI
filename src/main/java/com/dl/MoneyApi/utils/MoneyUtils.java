package com.dl.MoneyApi.utils;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.BigDecimal;

public class MoneyUtils {

    public static String formatMoney(BigDecimal valor){
            Money money = Money.of(CurrencyUnit.of("BRL"), valor);
            String symbol = money.getCurrencyUnit().getSymbol();
            String amount = money.getAmount().toString();
            return symbol + " " + amount;
    }
    public static BigDecimal setMoney(String valor){
        return new BigDecimal(valor);
    }
}
