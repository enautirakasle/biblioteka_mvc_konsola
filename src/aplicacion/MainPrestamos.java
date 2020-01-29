package aplicacion;

import java.util.ArrayList;
import java.util.Scanner;
import javax.security.auth.callback.ConfirmationCallback;

import modelo.bean.Libro;
import modelo.bean.Prestamo;
import modelo.bean.Socio;
import modelo.dao.PrestamoModelo;
import vista.LibroVista;
import vista.PrestamoVista;
import vista.SocioVista;

public class MainPrestamos {
	static final int SALIR = 0;
	static final int MOSTRAR_PRESTAMOS = 1;
	
	public static void main(String[] args) {
		PrestamoModelo pModelo;
		PrestamoVista pVista;

		int opcion;
		do {
			menuPrincipal();
			opcion = new Scanner(System.in).nextInt();
			
			switch (opcion) {
			case SALIR:
				System.out.println("Saliendo del programa..");
				break;
			case MOSTRAR_PRESTAMOS:
				pModelo = new PrestamoModelo();
				pVista = new PrestamoVista();
				ArrayList<Prestamo> prestamos = pModelo.selectAll();
				pVista.imprimirPrestamos(prestamos);
				System.out.println("");
			default:
				break;
			}
		} while (opcion != SALIR);
	}
	
	public static void menuPrincipal() {
		System.out.println(SALIR + ". Salir");
		System.out.println(MOSTRAR_PRESTAMOS + ". Mostrar todos los prestamos");
	}
}
