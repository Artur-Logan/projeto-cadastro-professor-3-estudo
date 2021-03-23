package com.artur.estudos.controllers;

import com.artur.estudos.dto.ProfessorRequest;
import com.artur.estudos.dto.ProfessorResponse;
import com.artur.estudos.exceptions.StandardError;
import com.artur.estudos.models.Professor;
import com.artur.estudos.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorResponse>> listar(){
        List<ProfessorResponse> professorResponses = professorService.listar();

        return ResponseEntity.ok(professorResponses);
    }

    @PostMapping
    public ResponseEntity<ProfessorResponse> salvar(@Valid @RequestBody ProfessorRequest professorRequest){
        ProfessorResponse professorResponse = professorService.salvar(professorRequest);

        return ResponseEntity.ok(professorResponse);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<ProfessorResponse> obter(@PathVariable Long id){

            ProfessorResponse professorResponse = professorService.obter(id);

            return ResponseEntity.ok().body(professorResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProfessorResponse> deletar(@PathVariable Long id){
        professorService.deletar(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponse> atualizar(@PathVariable Long id, @RequestBody ProfessorRequest professorRequest){
        ProfessorResponse professorResponse = professorService.atualizar(id, professorRequest);

        return ResponseEntity.ok(professorResponse);
    }
}