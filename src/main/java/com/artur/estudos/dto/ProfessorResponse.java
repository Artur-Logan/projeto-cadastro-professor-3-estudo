package com.artur.estudos.dto;

import com.artur.estudos.models.enuns.SalasEnum;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProfessorResponse {
    private Long id;
    private String nome;
    private String materia;
    private Integer idade;
    private LocalDate dataDeCadastro;
    private List<SalasEnum> salas;
}
