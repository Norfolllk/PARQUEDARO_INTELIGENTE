package com.krakedev.parqueadero.modelo;

public class Motocicleta extends Vehiculo {
    private int cilindraje;

    public Motocicleta(String placa, String propietario, int cilindraje) {
        super(placa, propietario);
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    @Override
    public double calcularTarifa(int horasPermanencia) {
        double tarifaPorHora = 0.75;

        if (cilindraje > 250) {
            tarifaPorHora = 1.00;
        }
        return tarifaPorHora * horasPermanencia;
    }

    @Override
    public String toString() {
        return "Motocicleta: getPlaca()=" + getPlaca() + ", getPropietario()=" + getPropietario() + ", getHoraIngreso()=" + getHoraIngreso() + ", cilindraje=" + cilindraje;
    }
}
