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
				ArrayList socios = sModelo.mostrarSocios();
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
				System.out.println("Escribe un caracter, y mostrara los usuarios que contengan ese caracter en su nombre o apellido");
				char caracter = new Scanner(System.in).next().charAt(0);
				break;
				
				
			case EDITAR_SOCIO:
				//TODO
				break;
				
				
			case ELIMINAR_SOCIO:
				sModelo = new SocioModelo();
				System.out.println("escribe un dni, para borrar su respectivo socio");
				String dniBorrar = new Scanner(System.in).nextLine();
				sModelo.borrarSocio(dniBorrar);
				break;
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
	}
}
