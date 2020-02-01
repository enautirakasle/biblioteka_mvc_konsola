package vista;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.bean.Libro;
import modelo.bean.Prestamo;
import modelo.bean.Socio;
import modelo.dao.PrestamoModelo;

public class PrestamoVista {
	PrestamoModelo pModelo;
	public static void imprimirPrestamos(ArrayList<Prestamo> prestamos) {
		for (int i = 0; i < prestamos.size(); i++) {
			Prestamo prestamo = prestamos.get(i);
			
			System.out.println(prestamo);
		}
	}
	
	public String getDniSocio() {
		System.out.println("Escribe dni de socio");
		String dni = new Scanner(System.in).nextLine();
		return dni;
	}
	
	
}
