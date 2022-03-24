package com.dl.MoneyApi.repositories;

import com.dl.MoneyApi.models.Extrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExtratoRepository extends JpaRepository<Extrato, Long> {

    @Query(value = "SELECT * FROM data WHERE ano = :ano AND mes = :mes", nativeQuery = true)
    Extrato buscarPorData(@Param(value = "ano")Integer ano, @Param(value = "mes")Integer mes);

}
