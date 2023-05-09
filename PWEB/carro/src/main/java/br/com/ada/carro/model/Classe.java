package br.com.ada.carro.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "classe")
@Data
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String uid;

    private String modelo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "classe")
    private Collection<Carro> carros = new ArrayList<>();
}
