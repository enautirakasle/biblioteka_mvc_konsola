package aplicacion;

import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import javax.security.auth.callback.ConfirmationCallback;

import modelo.bean.Libro;
import modelo.bean.Prestamo;
import modelo.bean.Socio;
import modelo.dao.LibroModelo;
import modelo.dao.PrestamoModelo;
import modelo.dao.SocioModelo;
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
		LibroModelo lModelo;
		SocioModelo sModelo;
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
				lModelo = new LibroModelo();
				sModelo = new SocioModelo();
				Prestamo prestamo = new Prestamo();
				Libro libro = new Libro();
				Socio socio = new Socio();
				
				System.out.println("Escribe dni de socio");
				String dniSocio = new Scanner(System.in).nextLine();
				System.out.println("Escribe titulo de libro");
				String tituloLibro = new Scanner(System.in).nextLine();
				
				ArrayList<Libro> libros = lModelo.selectAll();
				for (int i = 0; i < libros.size(); i++) {
					Libro unLibro = libros.get(i);
					if(unLibro.getTitulo().equals(tituloLibro)) {
						int idLibro = unLibro.getId();
						libro.setId(idLibro);
						
					}
				}
				ArrayList<Socio> socios = sModelo.mostrarSocios();
				for (int i = 0; i < socios.size(); i++) {
					Socio unSocio = socios.get(i);
					if(unSocio.getDni().equals(dniSocio)) {
						int idSocio = unSocio.getId();
						socio.setId(idSocio);
					}
				}
				Date fecha = new Date();
				
				
				prestamo.setLibro(libro);
				prestamo.setSocio(socio);
				prestamo.setFecha(new java.sql.Date(fecha.getTime()));
				prestamo.setDevuelto(false);
				
				pModelo.insertar(prestamo);
				
				break;
			case DEVOLVER_PRESTAMO:
				pModelo = new PrestamoModelo();
				lModelo = new LibroModelo();
				sModelo = new SocioModelo();
				System.out.println("Escribe dni de socio");
				String dnisocio = new Scanner(System.in).nextLine();
				System.out.println("Escribe titulo de libro");
				String titulolibro = new Scanner(System.in).nextLine();
				Prestamo prestamoO = new Prestamo();
				Libro libroO = new Libro();
				Socio socioO = new Socio();
				
				ArrayList<Libro> librosS = lModelo.selectAll();
				for (int i = 0; i < librosS.size(); i++) {
					Libro unLibro = librosS.get(i);
					if(unLibro.getTitulo().equals(titulolibro)) {
						int idlibro = unLibro.getId();
						libroO.setId(idlibro);
						
					}
				}
				ArrayList<Socio> sociosS = sModelo.mostrarSocios();
				for (int i = 0; i < sociosS.size(); i++) {
					Socio unSocio = sociosS.get(i);
					if(unSocio.getDni().equals(dnisocio)) {
						int idSocio = unSocio.getId();
						socioO.setId(idSocio);
					}
				}
				
				prestamoO.setLibro(libroO);
				prestamoO.setSocio(socioO);
				prestamoO.setDevuelto(true);
				
				pModelo.devolverPrestamo(prestamoO);
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
