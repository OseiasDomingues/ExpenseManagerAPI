package com.dl.MoneyApi.repositories;

import com.dl.MoneyApi.models.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DespesasRepository extends JpaRepository<Despesa,Long> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "insert into TABELA_RELACAO (extrato_id, despesas_id) values (:idExtrato,:idDespesas);",nativeQuery = true)
    void salvarEmExtrato(@Param(value = "idExtrato")Long idExtrato, @Param(value = "idDespesas")Long idDespesas);
}
