package br.com.letscode.zoo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="animal")
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String uid;

    private String nome;

    private int idade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Classe classe;

}
