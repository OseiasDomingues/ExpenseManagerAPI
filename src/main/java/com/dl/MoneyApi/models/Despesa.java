package com.dl.MoneyApi.models;

import com.dl.MoneyApi.utils.DateUtils;
import com.dl.MoneyApi.utils.MoneyUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Despesa")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Despesa implements Serializable {

    private static final long serialVersionUID = 1691617394339721982L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String conta;
    @NotBlank
    private String categoria;
    private String subCategoria;
    private String date;
    @NotNull
    private BigDecimal valor;


    public Despesa(Long id, String name, String conta, String categoria,String subCategoria,LocalDate date,String valor) {
        this.id = id;
        this.categoria = categoria;
        this.name = name;
        this.conta = conta;
        this.subCategoria = subCategoria;
        this.valor = new BigDecimal(valor);
        if(date == null){
            this.date = DateUtils.dateToStr(null,true);;
        }else{
            this.date = DateUtils.dateToStr(date,false);
        }
        this.categoria = categoria;
    }

    public String getValor() {
        return MoneyUtils.formatMoney(valor);
    }

    @JsonIgnore
    public String getValorForSet() {
        return valor.toString();
    }

    @JsonIgnore
    public BigDecimal getValorForCalc() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = MoneyUtils.setMoney(valor);
    }

}
