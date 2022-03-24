package com.dl.MoneyApi.models;

import com.dl.MoneyApi.utils.MoneyUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Data")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Extrato implements Serializable {

    private static final long serialVersionUID = 2372464615920817395L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer ano;
    private Integer mes;
    @OneToMany
    @JoinTable(name = "TabelaRelacao",joinColumns = @JoinColumn, inverseJoinColumns = @JoinColumn)
    @ToString.Exclude
    private List<Despesa> despesas = new ArrayList<>();
    private BigDecimal total;

    public Extrato(Long id, Integer ano, Integer mes, List<Despesa> despesas) {
        this.id = id;
        this.ano = ano;
        this.mes = mes;
        this.despesas = despesas;
    }

    public String getTotal() {
        return MoneyUtils.formatMoney(total);
    }

    @JsonIgnore
    public String getTotalForSet() {
        return total.toString();
    }

    @JsonIgnore
    public BigDecimal getTotalForCalc() {
        return total;
    }

    public void setTotal(String total) {
        this.total = MoneyUtils.setMoney(total);
    }

    public void setTotalForCalc(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Extrato that = (Extrato) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
