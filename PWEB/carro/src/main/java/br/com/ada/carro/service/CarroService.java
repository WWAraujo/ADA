package br.com.ada.carro.service;

import br.com.ada.carro.model.Carro;
import br.com.ada.carro.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarroService {

    @Autowired
    CarroRepository carroRepository;

    @Autowired
    ClasseService classeService;

    public List<Carro> listar() {
        return carroRepository.findWithClasses();
    }

    public void criar (Carro carro) {
        carro.setClasse(
                classeService.getByUid(carro.getClasse().getUid())
        );
        carro.setUid(UUID.randomUUID().toString());
        carroRepository.saveAndFlush(carro);
    }
}
