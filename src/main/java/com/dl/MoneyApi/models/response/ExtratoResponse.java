package com.dl.MoneyApi.models.response;

import com.dl.MoneyApi.models.Despesa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtratoResponse {
    private Long id;
    private Integer ano;
    private Integer mes;
    private String total;
    private List<Despesa> despesas = new ArrayList<>();
}
