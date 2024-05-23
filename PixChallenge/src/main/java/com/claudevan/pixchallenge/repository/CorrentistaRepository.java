package com.claudevan.pixchallenge.repository;

import com.claudevan.pixchallenge.model.entity.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CorrentistaRepository extends JpaRepository<Correntista, UUID> {

}
