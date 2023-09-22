package com.example.SpringExemplo.controllers;
import com.example.SpringExemplo.dto.CursoDTO;
import com.example.SpringExemplo.entites.Curso;
import com.example.SpringExemplo.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/cursos")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<CursoDTO>> findAll(){
        List<Curso> list= cursoService.listarCursos();
        List<CursoDTO> listDto = list.stream().map(CursoDTO::new).collect(Collectors.toList());
        return  ResponseEntity.ok().body(listDto);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<CursoDTO> findById(@PathVariable Long id){
        Curso obj = cursoService.listarCursoId(id);
        return  ResponseEntity.ok().body(new CursoDTO(obj));
    }
    @PostMapping(value = "/save")
    public ResponseEntity<Curso> insert(@RequestBody Curso obj){
        obj = cursoService.inserirCurso(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return  ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        cursoService.deletarCurso(id);
        return  ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id,@RequestBody Curso obj){
        obj=cursoService.atualizarCurso(id,obj);
        return  ResponseEntity.ok().body(obj);
    }

}
