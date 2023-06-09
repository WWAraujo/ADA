package br.com.ada.carro.dto;

import br.com.ada.carro.model.Carro;
import br.com.ada.carro.model.Classe;

import java.util.ArrayList;
import java.util.List;

public class FactoryDTO {

    public static ClasseDTO entityToDTO(Classe classe){

        if (classe == null){
            return null;
        }
        return ClasseDTO.builder()
                .uid(classe.getUid())
                .nome(classe.getModelo())
                .build();
    }

    public static Classe dtoToEntity(ClasseDTO classeDTO) {
        if (classeDTO == null) {
            return null;
        }
        Classe classe = new Classe();
        classe.setUid(classeDTO.getUid());
        classe.setModelo(classeDTO.getNome());
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

    public static CarroDTO entityToDTO(Carro carro) {
        if (carro == null) {
            return null;
        }
        return CarroDTO.builder()
                .uid(carro.getUid())
                .nome(carro.getNome())
                .potenciaMotor(carro.getPotenciaMotor())
                .classe(entityToDTO(carro.getClasse()))
                .build();
    }

    public static Carro dtoToEntity(CarroDTO carroDTO) {
        if (carroDTO == null) {
            return null;
        }
        Carro carro = new Carro();
        carro.setUid(carroDTO.getUid());
        carro.setNome(carroDTO.getNome());
        carro.setPotenciaMotor(carroDTO.getPotenciaMotor());
        if (carroDTO.getClasse() != null) {
            carro.setClasse(dtoToEntity(carroDTO.getClasse()));
        }
        return carro;
    }

    public  static List<CarroDTO> carrosToDTo(List<Carro> carros){
        List<CarroDTO> carrosDTO = new ArrayList<>();
        for (Carro carro: carros) {
            carrosDTO.add(FactoryDTO.entityToDTO(carro));
        }
        return carrosDTO;
    }
}
