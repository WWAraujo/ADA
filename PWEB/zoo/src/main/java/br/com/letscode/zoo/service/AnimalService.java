package br.com.letscode.zoo.service;

import br.com.letscode.zoo.model.Animal;
import br.com.letscode.zoo.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    ClasseService classeService;

    public List<Animal> listar() {
        return animalRepository.findWithClasses();
    }

    public void criar(Animal animal) {
        animal.setClasse(
                classeService.getByUid(animal.getClasse().getUid())
        );
        animal.setUid(UUID.randomUUID().toString());
        animalRepository.saveAndFlush(animal);
    }
}
