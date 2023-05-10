package br.com.letscode.zoo.controller;

import br.com.letscode.zoo.dto.AnimalDTO;
import br.com.letscode.zoo.dto.FactoryDTO;
import br.com.letscode.zoo.dto.ResultadoDTO;
import br.com.letscode.zoo.service.AnimalService;
import br.com.letscode.zoo.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *    C   CRIAR       POST
 *    R   LER         GET
 *    U   EDITAR      PUT
 *    D   DELETAR     DELETE
 */

@RestController
@RequestMapping("/animal")
public class AnimalController extends BaseController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private ClasseService classeService;

    @GetMapping("/lista")
    public List<AnimalDTO> listar(@RequestParam String filtro) {
        if (filtro != null && !filtro.isEmpty()) {
            //return animalService.filterByNome(filtro);
        }
        return FactoryDTO.animaisToDTO(animalService.listar());
    }

    @GetMapping
    public AnimalDTO detalhar(@RequestParam String nome) {
        return AnimalDTO.builder().nome(nome).idade(100).build();
    }

    @PostMapping
    public ResponseEntity<ResultadoDTO> criar(@RequestBody @Valid AnimalDTO animalDTO) {
        /** if (!classeService.contains(animalDTO.getClasse().getNome())) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(
                    new ResultadoDTO()
                            .putError("classe", "Não existe.")
            );
        } */
        System.out.println("Nome do Animal: "+ animalDTO.getNome());
        animalService.criar(FactoryDTO.dtoToEntity(animalDTO));
        return ResponseEntity.ok(
                new ResultadoDTO()
                    .setResultado(true)
                    .setMensagem("Animal "+ animalDTO.getNome() +" criado com sucesso...")
        );
    }

    @PutMapping
    public ResultadoDTO editar(@RequestBody AnimalDTO animalDTO) {
        return new ResultadoDTO()
                .setResultado(true)
                .setMensagem("Animal "+ animalDTO.getNome() +" editado com sucesso...");
    }

    @DeleteMapping
    public ResponseEntity<ResultadoDTO> deletar(@RequestParam String nome) {
        int removido = 0;
        /** for (int i = animalDTOs.size() - 1; i >= 0; i--) {
            AnimalDTO animalDTO = animalDTOs.get(i);
            if (animalDTO.getNome().equalsIgnoreCase(nome)) {
                animalDTOs.remove(i);
                removido++;
            }
        } */
        if (removido == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResultadoDTO()
                            .setResultado(false)
                            .setMensagem("Não foi encontrado nenhum animal com este nome...")
            );
        }
        return ResponseEntity.ok(
                new ResultadoDTO()
                    .setResultado(true)
                    .setMensagem(removido + " animais com o nome "+ nome +" foram deletados...")
        );
    }

}
