package aplicacion;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.bean.Socio;
import modelo.dao.SocioModelo;
import vista.SocioVista;


public class MainSocios {
	static final int SALIR = 1;
	static final int MOSTRAR_SOCIOS = 2;
	static final int MOSTRAR_SOCIO = 3;
	static final int BUSCAR = 4;
	static final int EDITAR_SOCIO = 5;
	static final int ELIMINAR_SOCIO = 6;
	static final int CREAR_SOCIO = 7;
	public static void main(String[] args) {
		
		
		
		int opcion;
		SocioModelo sModelo;
		SocioVista sVista;
		do {
		
			menuPrincipal();
			opcion = new Scanner(System.in).nextInt();
			
			switch (opcion) {
			case SALIR:
				System.out.println("Saliendo..");
				break;
				
				
			case MOSTRAR_SOCIOS:
				sModelo = new SocioModelo();
				sVista = new SocioVista();
				ArrayList <Socio> socios = sModelo.mostrarSocios();
				sVista.imprimirSocios(socios);
				break;
				
				
			case MOSTRAR_SOCIO:
				sModelo = new SocioModelo();
				System.out.println("Escribe dni del socio el cual quieres mostrar por pantalla");
				String dni = new Scanner(System.in).nextLine();
				sModelo.mostrarSocio(dni);
				Socio socio = sModelo.mostrarSocio(dni);
				System.out.println(socio);
				break;
				
				
			case BUSCAR:
				sModelo = new SocioModelo();
				sVista = new SocioVista();
				System.out.println("Escribe un caracter, y mostrara los usuarios que contengan ese caracter en su nombre o apellido");
				char caracter = new Scanner(System.in).next().charAt(0);
				ArrayList<Socio> sociosPorLetra = sModelo.buscarPorCaracter(caracter);
				sVista.imprimirSocios(sociosPorLetra);
				break;
				
				
			case EDITAR_SOCIO:
				sModelo = new SocioModelo();
				System.out.println("Escribe el dni del socio que quieras modificar sus datos");
				String dniCambiar = new Scanner(System.in).nextLine();
				System.out.println("Su nueva direccion :");
				String direccionCambiar = new Scanner(System.in).nextLine();
				System.out.println("Su nueva poblacion :");
				String poblacionCambiar = new Scanner(System.in).nextLine();
				System.out.println("Su nueva provincia :");
				String provinciaCambiar = new Scanner(System.in).nextLine();
				sModelo.editarSocio(dniCambiar, direccionCambiar, poblacionCambiar, provinciaCambiar);
				break;
				
				
			case ELIMINAR_SOCIO:
				sModelo = new SocioModelo();
				System.out.println("escribe un dni, para borrar su respectivo socio");
				String dniBorrar = new Scanner(System.in).nextLine();
				sModelo.borrarSocio(dniBorrar);
				break;
			
			case CREAR_SOCIO:
				sModelo = new SocioModelo();
				sVista = new SocioVista();
				Socio nuevoSocio = sVista.getSocio();
				sModelo.insertarSocio(nuevoSocio);
			default:
				break;
			}
		} while (opcion != SALIR);
		
		
	}
	
	public static void menuPrincipal() {
		System.out.println(SALIR + " Salir");
		System.out.println(MOSTRAR_SOCIOS + " Mostrar todos los socios");
		System.out.println(MOSTRAR_SOCIO + " Mostrar un socio");
		System.out.println(BUSCAR + " Buscar por parte del nombre");
		System.out.println(EDITAR_SOCIO + " Editar socio");
		System.out.println(ELIMINAR_SOCIO + " Eliminar socios");
		System.out.println(CREAR_SOCIO + " Crear nuevo socio");
	}
}
