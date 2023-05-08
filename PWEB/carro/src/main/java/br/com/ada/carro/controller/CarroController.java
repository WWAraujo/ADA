package br.com.ada.carro.controller;

import br.com.ada.carro.dto.CarroDTO;
import br.com.ada.carro.dto.ResultadoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {

    /**
     * C    Criar       POST
     * R    Ler         GET
     * U    Editar      PUT
     * D    Deletar     DELETE
     * @return
     */

    private List<CarroDTO> carroDTOs = new ArrayList<>();

    @GetMapping("/lista")
    public List<CarroDTO> detalhe(@RequestParam String filtro) {
        if (filtro != null && !filtro.isEmpty()) {
            List<CarroDTO> listaFiltrada = new ArrayList<>();
            for (CarroDTO carroDTO : carroDTOs) {
                if (carroDTO.getModelo().toLowerCase().contains(filtro.toLowerCase())) {
                    listaFiltrada.add(carroDTO);
                }
            }
            return listaFiltrada;
        }
        return carroDTOs;
    }

    @GetMapping("/detalhe")
    public CarroDTO detalhe(@RequestParam String modelo, String marca) {
        return new CarroDTO().setMarca(marca).setModelo(modelo);
    }

    @PostMapping
    public ResponseEntity<ResultadoDTO> criar(@RequestBody CarroDTO carroDTO){
        if (carroDTO.getMotor() < 1.0 || carroDTO.getMotor() > 10){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(
                    new ResultadoDTO()
                    .setResultado(false)
                    .setMensagem("Carro "+ carroDTO.getMarca() +
                            " " + carroDTO.getModelo() + " com motor "+ carroDTO.getMotor() + " é invalído!")
            );
        }
        if (carroDTO.getModelo() == null || carroDTO.getModelo().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(
                     new ResultadoDTO()
                    .setResultado(false)
                    .setMensagem("Carro "+ carroDTO.getModelo() + " é invalído!")
            );
        }
        System.out.println("Nome do carro "+carroDTO.getModelo());
        carroDTOs.add(carroDTO);
        return ResponseEntity.ok(
                new ResultadoDTO()
                        .setResultado(true)
                        .setMensagem("Carro "+ carroDTO.getMarca() + " " + carroDTO.getModelo() + " criado com sucesso")
            );
    }

    @PutMapping
    public ResultadoDTO editar(@RequestBody CarroDTO carroDTO){
        return new ResultadoDTO()
                .setResultado(true)
                .setMensagem("Carro " + carroDTO.getMarca() + " " + carroDTO.getModelo() + " editado com sucesso");
    }

    @DeleteMapping
    public ResponseEntity<ResultadoDTO> deletar(@RequestParam String modelo) {
        int removido = 0;
        for (int i = carroDTOs.size() -1; i >= 0; i--){
            CarroDTO carroDTO = carroDTOs.get(i);
            if (carroDTO.getModelo().equalsIgnoreCase(modelo)){
                carroDTOs.remove(i);
                removido++;
            }
        }
        if (removido == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResultadoDTO()
                            .setResultado(false)
                            .setMensagem("Não foi encontrado nenhum carro com essse nome...")
            );
        }
        return ResponseEntity.ok(
                new ResultadoDTO()
                        .setResultado(true)
                        .setMensagem(removido + " carro(s) deletado(s) com sucesso...")
        );
    }

}
