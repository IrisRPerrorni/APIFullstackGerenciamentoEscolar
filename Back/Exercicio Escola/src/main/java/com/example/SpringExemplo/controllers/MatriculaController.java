package com.example.SpringExemplo.controllers;
import com.example.SpringExemplo.dto.MatriculaDTO;
import com.example.SpringExemplo.entites.Matricula;
import com.example.SpringExemplo.services.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> findAll(){
        List<Matricula> list= matriculaService.listarMatriculas();
        List<MatriculaDTO> listDto = list.stream().map(MatriculaDTO::new).collect(Collectors.toList());
        return  ResponseEntity.ok().body(listDto);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<MatriculaDTO> findById(@PathVariable Long id){
        Matricula obj = matriculaService.listarMatriculaId(id);
        return  ResponseEntity.ok().body(new MatriculaDTO(obj));
    }
    @PostMapping(value = "/save")
    public ResponseEntity<Matricula> insert(@RequestBody Matricula obj){
        obj = matriculaService.inserirMatricula(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return  ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        matriculaService.deletarMatricula(id);
        return  ResponseEntity.noContent().build();
    }


}
