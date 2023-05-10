package br.com.letscode.zoo.repository;

import br.com.letscode.zoo.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClasseRepository extends JpaRepository<Classe, Long> {

    @Query("SELECT c FROM Classe c WHERE c.uid = :uid")
    List<Classe> findByUid(@Param("uid") String uid);

}
