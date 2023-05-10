package br.com.letscode.zoo.dto;

import br.com.letscode.zoo.model.Animal;
import br.com.letscode.zoo.model.Classe;

import java.util.ArrayList;
import java.util.List;

public class FactoryDTO {
    public static ClasseDTO entityToDTO(Classe classe) {
        if (classe == null) {
            return null;
        }
        return ClasseDTO.builder()
                .uid(classe.getUid())
                .nome(classe.getNome())
                .build();
    }

    public static Classe dtoToEntity(ClasseDTO classeDTO) {
        if (classeDTO == null) {
            return null;
        }
        Classe classe = new Classe();
        classe.setUid(classeDTO.getUid());
        classe.setNome(classeDTO.getNome());
        return classe;
    }

    public static List<ClasseDTO> classesToDTO(List<Classe> classes) {
        List<ClasseDTO> classesDTO = new ArrayList<>();
        for (Classe classe : classes) {
            classesDTO.add(
                    FactoryDTO.entityToDTO(classe)
            );
        }
        return classesDTO;
    }

    public static AnimalDTO entityToDTO(Animal animal) {
        if (animal == null) {
            return null;
        }
        return AnimalDTO.builder()
                .uid(animal.getUid())
                .nome(animal.getNome())
                .idade(animal.getIdade())
                .classe(entityToDTO(animal.getClasse()))
                .build();
    }

    public static Animal dtoToEntity(AnimalDTO animalDTO) {
        if (animalDTO == null) {
            return null;
        }
        Animal animal = new Animal();
        animal.setUid(animalDTO.getUid());
        animal.setNome(animalDTO.getNome());
        animal.setIdade(animalDTO.getIdade());
        if (animalDTO.getClasse() != null) {
            animal.setClasse(dtoToEntity(animalDTO.getClasse()));
        }
        return animal;
    }

    public static List<AnimalDTO> animaisToDTO(List<Animal> animais) {
        List<AnimalDTO> animaisDTO = new ArrayList<>();
        for (Animal animal : animais) {
            animaisDTO.add(
                    FactoryDTO.entityToDTO(animal)
            );
        }
        return animaisDTO;
    }
}
