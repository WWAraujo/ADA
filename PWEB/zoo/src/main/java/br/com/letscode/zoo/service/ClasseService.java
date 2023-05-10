package br.com.letscode.zoo.service;

import br.com.letscode.zoo.dto.ClasseDTO;
import br.com.letscode.zoo.model.Classe;
import br.com.letscode.zoo.repository.ClasseRepository;
import br.com.letscode.zoo.service.exception.ClasseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    public List<Classe> listar() {
        return classeRepository.findAll();
    }

    public void criar(Classe classe) {
        classe.setUid(UUID.randomUUID().toString());
        classeRepository.saveAndFlush(classe);
    }

    public void editar(String uid, Classe classe) throws ClasseNotFoundException {
        List<Classe> classes = classeRepository.findByUid(uid);
        if (classes.size() == 1) {
            Classe classeDB = classes.get(0);
            classeDB.setNome(classe.getNome());
            classeRepository.saveAndFlush(classeDB);
        } else {
            throw new ClasseNotFoundException("A classe "+ uid +" não foi encontrada.");
        }
    }

    public boolean deletar(String uid) {
        List<Classe> classes = classeRepository.findByUid(uid);
        if (classes.size() == 0) {
            return false;
        }
        Classe classe = classes.get(0);
        classeRepository.delete(classe);
        return true;
    }

    public Classe getByUid(String uid) {
        List<Classe> classes = classeRepository.findByUid(uid);
        if (classes.size() == 1) {
            return classes.get(0);
        }
        return null;
    }
}
