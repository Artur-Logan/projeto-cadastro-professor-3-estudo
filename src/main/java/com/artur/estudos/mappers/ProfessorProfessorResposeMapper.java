package com.artur.estudos.mappers;

import com.artur.estudos.dto.ProfessorResponse;
import com.artur.estudos.models.Professor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfessorProfessorResposeMapper {
    ProfessorResponse toDto(Professor professor);
    Professor toModels(ProfessorResponse professorResponse);
}
