package vista;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.bean.Socio;

public class SocioVista {
	public static void imprimirSocios(ArrayList<Socio> socios) {
		for (int i = 0; i < socios.size(); i++) {
			Socio socio = socios.get(i);
			System.out.println(socio);
		}
	}
	
	
	public Socio getSocio() {
		Socio nuevoSocio = new Socio();
		System.out.println("Escribe nombre para nuevo socio:");
		nuevoSocio.setNombre(new Scanner(System.in).nextLine()); 
		System.out.println("Su apellido:");
		nuevoSocio.setApellido(new Scanner(System.in).nextLine());
		System.out.println("Su direccion:");
		nuevoSocio.setDireccion(new Scanner(System.in).nextLine());
		System.out.println("Su poblacion:");
		nuevoSocio.setPoblacion(new Scanner(System.in).nextLine());
		System.out.println("Su provincia:");
		nuevoSocio.setProvincia(new Scanner(System.in).nextLine());
		System.out.println("Su dni:");
		nuevoSocio.setDni(new Scanner(System.in).nextLine());
		
		return nuevoSocio;
	}
}
