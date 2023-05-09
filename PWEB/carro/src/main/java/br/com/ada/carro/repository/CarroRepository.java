package br.com.ada.carro.repository;

import br.com.ada.carro.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    @Query("SELECT a FROM Carro a JOIN FETCH a.classe c")
    List<Carro> findWithClasses();
}
