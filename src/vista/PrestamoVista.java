package vista;

import java.util.ArrayList;

import modelo.bean.Prestamo;

public class PrestamoVista {
	public static void imprimirPrestamos(ArrayList<Prestamo> prestamos) {
		for (int i = 0; i < prestamos.size(); i++) {
			Prestamo prestamo = prestamos.get(i);
			
			System.out.println(prestamo);
		}
	}
	
}
