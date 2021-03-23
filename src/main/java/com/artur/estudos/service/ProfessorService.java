package com.artur.estudos.service;

import com.artur.estudos.dto.ProfessorRequest;
import com.artur.estudos.dto.ProfessorResponse;
import com.artur.estudos.exceptions.EntityMenorDeIdade;
import com.artur.estudos.exceptions.EntityNotFoundId;
import com.artur.estudos.mappers.ProfessorProfessorRequestMapper;
import com.artur.estudos.mappers.ProfessorProfessorResposeMapper;
import com.artur.estudos.models.Professor;
import com.artur.estudos.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;
    private final ProfessorProfessorRequestMapper professorProfessorRequestMapper;
    private final ProfessorProfessorResposeMapper professorProfessorResposeMapper;

    public ProfessorResponse salvar(ProfessorRequest professorRequest) {
        Professor professor = professorProfessorRequestMapper.toModels(professorRequest);

        professor.setDataDeCadastro(LocalDate.now());
        if (professor.getIdade() < 18){
            throw new EntityMenorDeIdade("È necessario ter mais de 18 anos");
        }
        professorRepository.save(professor);

        return professorProfessorResposeMapper.toDto(professor);
    }

    public List<ProfessorResponse> listar(){
        List<Professor> listaProfessor = professorRepository.findAll();

        List<ProfessorResponse> listaProfessorResponse = new ArrayList<>();
        for (Professor professor : listaProfessor){
            ProfessorResponse professorResponse = professorProfessorResposeMapper.toDto(professor);
            listaProfessorResponse.add(professorResponse);
        }

        return listaProfessorResponse;
    }

    public void deletar(Long id){
        Professor professor = professorRepository.getOne(id);

        professorRepository.delete(professor);
    }

    public ProfessorResponse atualizar(Long id, ProfessorRequest professorRequest){
        Professor professor = professorRepository.getOne(id);

        professor.setNome(professorRequest.getNome());
        professor.setMateria(professorRequest.getMateria());
        professor.setIdade(professorRequest.getIdade());
        professor.setSalas(professorRequest.getSalas());

        return professorProfessorResposeMapper.toDto(professor);
    }

    public ProfessorResponse obter(Long id){
        Professor professor = professorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundId("Não foi encontrado o Id " + id));

        return professorProfessorResposeMapper.toDto(professor);
    }
}