package com.claudevan.pixchallenge.repositories;

import com.claudevan.pixchallenge.model.entity.Chave;
import com.claudevan.pixchallenge.model.entity.ChaveId;
import com.claudevan.pixchallenge.model.entity.Conta;
import com.claudevan.pixchallenge.model.enums.TipoChave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChaveRepository extends JpaRepository<Chave, ChaveId> {
    Optional<Chave> findChaveByValorAndTipoChave(String valor, TipoChave tipoChave);

    Optional<Chave> findChaveByConta(Conta contaSalva);
}
