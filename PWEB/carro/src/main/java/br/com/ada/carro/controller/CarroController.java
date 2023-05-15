package br.com.ada.carro.controller;

import br.com.ada.carro.dto.CarroDTO;
import br.com.ada.carro.dto.FactoryDTO;
import br.com.ada.carro.dto.ResultadoDTO;
import br.com.ada.carro.service.CarroService;
import br.com.ada.carro.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController extends BaseController {

    /**
     * R    Ler         GET
     * C    Criar       POST
     * U    Editar      PUT
     * D    Deletar     DELETE
     */

    @Autowired
    private CarroService carroService;

    @Autowired
    private ClasseService classeService;

    @GetMapping("/lista")
    public List<CarroDTO> listar(@RequestParam String filtro) {

        if (filtro != null && !filtro.isEmpty()) {
            //return carroService.filterByNome(filtro);
        }
        return FactoryDTO.carrosToDTo(carroService.listar());
    }

    @GetMapping
    public CarroDTO detalhe(@RequestParam String modelo, String potenciaMotor) {
        return CarroDTO.builder().nome(modelo).potenciaMotor(Double.parseDouble(potenciaMotor)).build();
    }

    @PostMapping
    public ResponseEntity<ResultadoDTO> criar(@RequestBody CarroDTO carroDTO) {
        System.out.println("Nome do carro: " + carroDTO.getNome());
        carroService.criar(FactoryDTO.dtoToEntity(carroDTO));
        return ResponseEntity.ok(
                new ResultadoDTO().setResultado(true).setMensagem(carroDTO.getNome()+ " criado com sucesso...")
        );
    }


    @PutMapping
    public ResultadoDTO editar(@RequestBody CarroDTO carroDTO) {
        return new ResultadoDTO()
                .setResultado(true)
                .setMensagem("Carro "+ carroDTO.getNome() +" "+ carroDTO.getPotenciaMotor() +" editado com sucesso");
    }

    @DeleteMapping
    public ResponseEntity<ResultadoDTO> deletar (@RequestParam String modelo) {

        int removido = 0;

        if (removido == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResultadoDTO()
                            .setResultado(false)
                            .setMensagem("Não foi encontrado nenhum carro com essse nome...")
            );
        }
        return ResponseEntity.ok(
                new ResultadoDTO()
                        .setResultado(true)
                        .setMensagem(removido+ " carro(s) deletado(s) com sucesso...")
        );
    }

}
