package com.krakedev.parqueadero.modelo;

public class Auto extends Vehiculo {

	private int numeroPuertas;
	private static double tarifa_hora = 1.50;
    private static int limite_horas_sin_recargo = 4;
    private static double recargo_estadia_prolongada  = 2.00;

    public Auto() {
        super();
    }

    public Auto(String placa, String propietario, int numeroPuertas) {
        super(placa, propietario);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public double calcularTarifa(int horasPermanencia) {
        double total = horasPermanencia * tarifa_hora ;
        if (horasPermanencia > limite_horas_sin_recargo) {
            total += recargo_estadia_prolongada ;
        }
        return total;
    }

    @Override
    public String toString() {
    	return "Auto: getPlaca()=" + getPlaca() + ", getPropietario()=" + getPropietario() + ", getHoraIngreso()=" + getHoraIngreso() + ", numeroPuertas=" + numeroPuertas ;
    }
}
