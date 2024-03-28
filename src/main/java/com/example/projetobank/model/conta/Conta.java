package com.example.projetobank.model.conta;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Conta {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private Long numero;
    @Positive
    private Long agencia;
    @NotBlank
    private String nomeTitular;
    @CPF(message = "CPF, inválido")
    private String cpf;
    @PastOrPresent
    private LocalDate data;

    private BigDecimal saldo;

    private boolean ativa;

}
