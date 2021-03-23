package com.artur.estudos.mappers;

import com.artur.estudos.dto.ProfessorRequest;
import com.artur.estudos.models.Professor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorProfessorRequestMapper {
    ProfessorRequest toDto(Professor professor);
    Professor toModels(ProfessorRequest professorRequest);
}
