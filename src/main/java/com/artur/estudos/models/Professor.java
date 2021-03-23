package com.artur.estudos.models;

import com.artur.estudos.models.enuns.SalasEnum;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String materia;
    private Integer idade;
    private LocalDate dataDeCadastro;

    @ElementCollection
    @CollectionTable(name = "salas", joinColumns = @JoinColumn (name = "id"))
    @Enumerated(EnumType.STRING)
    private List<SalasEnum> salas;
}
