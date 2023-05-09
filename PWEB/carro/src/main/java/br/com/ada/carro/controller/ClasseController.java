package br.com.ada.carro.controller;

import br.com.ada.carro.dto.ClasseDTO;
import br.com.ada.carro.dto.FactoryDTO;
import br.com.ada.carro.dto.ResultadoDTO;
import br.com.ada.carro.service.ClasseService;
import br.com.ada.carro.service.exception.ClasseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classe")
public class ClasseController {

    private ClasseService classeService;

    @GetMapping("/listar")
    public ResponseEntity<List<ClasseDTO>> listar() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(FactoryDTO.classesToDTO(classeService.listar())
                );
    }

    @PostMapping
    public ResponseEntity<ResultadoDTO> criar(@RequestBody ClasseDTO classeDTO){

        classeService.criar(FactoryDTO.dtoToEntity(classeDTO));
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResultadoDTO()
                        .setResultado(true)
                        .setMensagem("A classe tipo " + classeDTO.getNome() + " foi criada com sucesso")
        );
    }

    @PutMapping
    public ResponseEntity<ResultadoDTO> editar(
            @RequestParam (name = "uid") String uid,
            @RequestBody ClasseDTO classeDTO){

        ClasseDTO classeEncontrada = null;

        try {
            classeService.editar(uid, FactoryDTO.dtoToEntity(classeDTO));
        } catch (ClasseNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ResultadoDTO()
                            .setResultado(false)
                            .setMensagem(e.getMessage())
                    );
        }

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResultadoDTO()
                        .setResultado(true)
                        .setMensagem("A classe tipo " + classeDTO.getNome() + " foi editada com sucesso")
        );
    }

    @DeleteMapping
    public ResponseEntity<ResultadoDTO> deletar(@RequestParam (name = "uid") String uid) {

        boolean resultado = classeService.deletar(uid);
        if (resultado == false) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResultadoDTO()
                            .setResultado(false)
                            .setMensagem("A classe "+ uid +" não foi encontrada.")
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResultadoDTO()
                        .setResultado(true)
                        .setMensagem("A classe carro " + uid + " foi deletada com sucesso")
        );
    }
}
