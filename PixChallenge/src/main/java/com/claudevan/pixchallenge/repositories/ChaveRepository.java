package com.claudevan.pixchallenge.repositories;

import com.claudevan.pixchallenge.model.entity.Chave;
import com.claudevan.pixchallenge.model.entity.ChaveComposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChaveRepository extends JpaRepository<Chave, ChaveComposta> {
}
