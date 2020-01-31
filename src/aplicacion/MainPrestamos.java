package aplicacion;

import java.util.Date;
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
	static final int VER_PRESTAMOS_DE_USUARIO = 2;
	static final int VER_PRESTAMOS_PENDIENTES_DE_USUARIO = 3;
	static final int VER_INFO_DE_LIBRO = 4;
	static final int REALIZAR_PRESTAMO = 5;
	static final int DEVOLVER_PRESTAMO = 6;
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
				break;
			case VER_PRESTAMOS_DE_USUARIO:
				//TODO
				break;
			case VER_PRESTAMOS_PENDIENTES_DE_USUARIO:
				//TODO
				break;
			case VER_INFO_DE_LIBRO:
				//TODO
				break;
			case REALIZAR_PRESTAMO:
				pModelo = new PrestamoModelo();
				Prestamo prestamo = new Prestamo();
				Libro libro = new Libro();
				Socio socio = new Socio();
				
				System.out.println("Escribe dni de socio");
				String dniSocio = new Scanner(System.in).nextLine();
				System.out.println("Escribe titulo de libro");
				String tituloLibro = new Scanner(System.in).nextLine();
				
				ArrayList<Prestamo> prestamosBuscar = pModelo.selectAll();
				for (int i = 0; i < prestamosBuscar.size(); i++) {
					if(prestamosBuscar.get(i).getSocio().getDni().equals(dniSocio) && prestamosBuscar.get(i).getLibro().getTitulo().equals(tituloLibro)) {
						int idSocio = prestamosBuscar.get(i).getSocio().getId();
						int idLibro = prestamosBuscar.get(i).getLibro().getId();
						libro.setId(idLibro);
						socio.setId(idSocio);
						
					}
				}
				Date fecha = new Date();
				System.out.println(fecha);
				
				prestamo.setLibro(libro);
				prestamo.setSocio(socio);
				prestamo.setDevuelto(false);
				prestamo.setFecha(fecha);
				pModelo.devolverPrestamo(prestamo);
				
				break;
			case DEVOLVER_PRESTAMO:
				//TODO
				break;
				
			default:
				break;
			}
		} while (opcion != SALIR);
		
	}
	
	public static void menuPrincipal() {
		System.out.println(SALIR + ". Salir");
		System.out.println(MOSTRAR_PRESTAMOS + ". Mostrar todos los prestamos");
		System.out.println(VER_PRESTAMOS_DE_USUARIO + ". Mostrar prestamos de usuario");
		System.out.println(VER_PRESTAMOS_PENDIENTES_DE_USUARIO + ". ver prestamos sin devolver de usuario");
		System.out.println(VER_INFO_DE_LIBRO + ". Ver informacion de libro");
		System.out.println(REALIZAR_PRESTAMO + ". Realizar prestamo");
		System.out.println(DEVOLVER_PRESTAMO + ". Devolver prestamo");
	}
}
