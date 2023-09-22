package com.example.SpringExemplo.controllers;
import com.example.SpringExemplo.dto.AlunoDTO;
import com.example.SpringExemplo.entites.Aluno;
import com.example.SpringExemplo.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/alunos")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoDTO>> findAll(){
        List<Aluno> list= alunoService.listarAlunos();
        List<AlunoDTO> listDto = list.stream().map(AlunoDTO::new).collect(Collectors.toList());
        return  ResponseEntity.ok().body(listDto);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<AlunoDTO> findById(@PathVariable Long id){
        Aluno obj = alunoService.listarAlunoId(id);
        return  ResponseEntity.ok().body(new AlunoDTO(obj));
    }
    @PostMapping(value = "/save")
    public ResponseEntity<Aluno> insert(@RequestBody Aluno obj){
        obj = alunoService.inserirAluno(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return  ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        alunoService.deletarAluno(id);
        return  ResponseEntity.noContent().build();
    }


}
