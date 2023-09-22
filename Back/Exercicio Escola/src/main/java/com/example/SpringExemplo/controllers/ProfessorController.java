package com.example.SpringExemplo.controllers;
import com.example.SpringExemplo.dto.ProfessorDTO;
import com.example.SpringExemplo.entites.Professor;
import com.example.SpringExemplo.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/professores")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> findAll(){
        List<Professor> list= professorService.listarProfessores();
        List<ProfessorDTO> listDto = list.stream().map(ProfessorDTO::new).collect(Collectors.toList());
        return  ResponseEntity.ok().body(listDto);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProfessorDTO> findById(@PathVariable Long id){
        Professor obj = professorService.listarProfessorId(id);
        return  ResponseEntity.ok().body(new ProfessorDTO(obj));
    }
    @PostMapping(value = "/save")
    public ResponseEntity<Professor> insert(@RequestBody Professor obj){
        obj = professorService.inserirProfessor(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return  ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        professorService.deletarProfessor(id);
        return  ResponseEntity.noContent().build();
    }


}
