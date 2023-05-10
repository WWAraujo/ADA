package br.com.letscode.zoo.repository;

import br.com.letscode.zoo.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    @Query("SELECT a FROM Animal a JOIN FETCH a.classe c")
    List<Animal> findWithClasses();
}
