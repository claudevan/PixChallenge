package com.claudevan.pixchallenge.repositories;

import com.claudevan.pixchallenge.model.entity.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CorrentistaRepository extends JpaRepository<Correntista, UUID> {

}
