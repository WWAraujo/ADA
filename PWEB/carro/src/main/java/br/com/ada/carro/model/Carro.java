package br.com.ada.carro.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="carro")
@Data
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String uid;

    private String nome;

    private double potenciaMotor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Classe classe;
}
