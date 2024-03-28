package com.example.projetobank.repository;

import com.example.projetobank.model.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    Optional<Conta>findByCpf(String cpf);
}
