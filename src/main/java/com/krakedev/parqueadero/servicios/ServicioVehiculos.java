package com.krakedev.parqueadero.servicios;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import com.krakedev.parqueadero.modelo.Vehiculo;

@Service
public class ServicioVehiculos {

	private ArrayList<Vehiculo> parqueadero = new ArrayList<>();
	private final int capacidadmax = 10;

	public Vehiculo buscarPorPlaca(String placa) {
		for (Vehiculo vehiculo : parqueadero) {
			if (vehiculo.getPlaca().equals(placa)) {
				return vehiculo;
			}
		}
		return null;
	}

	public boolean ingresarVehiculo(Vehiculo vehiculo) {
		if (parqueadero.size() >= capacidadmax) {
			System.out.println("Parqueadero lleno");
			return false;
		}

		Vehiculo encontrado = buscarPorPlaca(vehiculo.getPlaca());
		if (encontrado != null) {
			System.out.println("La placa ya existe");
			return false;
		}
		parqueadero.add(vehiculo);
		return true;
	}

	public Vehiculo retirarVehiculo(String placa) {
		Vehiculo encontrado = buscarPorPlaca(placa);

		if (encontrado == null) {
			System.out.println("Vehiculo no existe");
			return null;
		}
		parqueadero.remove(encontrado);
		return encontrado;
	}

	public ArrayList<Vehiculo> listarVehiculos() {
		return parqueadero;
	}
}
