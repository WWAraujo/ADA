package br.com.letscode.zoo.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="classe")
@Data
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String uid;

    private String nome;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "classe")
    private Collection<Animal> animais = new ArrayList<>();
}
