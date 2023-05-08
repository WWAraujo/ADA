package br.com.ada.carro.dto;

public class CarroDTO {

    private String marca;
    private String modelo;

    private double motor;

    public double getMotor() {
        return motor;
    }

    public CarroDTO setMotor(double motor) {
        this.motor = motor;
        return this;
    }

    public String getMarca() {
        return marca;
    }

    public CarroDTO setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public String getModelo() {
        return modelo;
    }

    public CarroDTO setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }
}
