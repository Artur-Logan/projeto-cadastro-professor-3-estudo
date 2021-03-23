package com.artur.estudos.dto;

import com.artur.estudos.models.enuns.SalasEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ProfessorRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String materia;
    @NotNull
    private Integer idade;
    private List<SalasEnum> salas;
}
