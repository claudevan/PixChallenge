package com.claudevan.pixchallenge.repositories;

import com.claudevan.pixchallenge.model.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ContaRepository extends JpaRepository<Conta, UUID> {
    @Query("Select c.correntista.id From Conta c Where c.conta = ?1 and  c.agencia = ?2")
    UUID findCorrentistaByAgenciaConta(Integer Agencia, Integer Conta);

    Optional<Conta> findContaByAgenciaAndConta(Integer agencia, Integer conta);
}
