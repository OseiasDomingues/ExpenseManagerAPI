package com.dl.MoneyApi.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static String dateToStr(LocalDate date, boolean dateIsNull) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (Utils.isTrue(dateIsNull)) {
            return LocalDate.now().format(formatter);
        } else {
            return date.format(formatter);
        }
    }
}
