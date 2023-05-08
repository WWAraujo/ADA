package br.com.ada.carro.controller;

import br.com.ada.carro.dto.ClasseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/classe")
public class ClasseController {

    private List<ClasseDTO> classes = new ArrayList<>() {{
        add(new ClasseDTO().setNome("sedã"));
        add(new ClasseDTO().setNome("SUV"));
    }};
    @GetMapping("/lista")
    public ResponseEntity<List<?>> lista() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                classes);
    }

    @PostMapping
    public String criar(@RequestBody ClasseDTO classeDTO){
        classes.add(classeDTO);
        return "Criado com sucesso...";
    }
}
