package vista;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.bean.Libro;

public class LibroVista {
	public static void imprimirLibros(ArrayList <Libro> libros) {
		for (int i = 0; i < libros.size(); i++) {
			System.out.println(libros.get(i));
		}
	}
	
	public static void imprimirLibrosMasLargos (ArrayList <Libro> librosMasLargos) {
		for (int i = 0; i < librosMasLargos.size(); i++) {
			Libro libro = librosMasLargos.get(i);
			System.out.println(libro);
		}
	}
	
	public static void imprimirPorTitulo (ArrayList <Libro> librosPorTitulo) {
		for (int i = 0; i < librosPorTitulo.size(); i++) {
			Libro libro = librosPorTitulo.get(i);
			System.out.println(libro);
		}
	}
	
	public Libro getLibro() {
		Libro libroNuevo = new Libro();
		Scanner scan = new Scanner(System.in);
		System.out.println("Su titulo:");
		libroNuevo.setTitulo(scan.nextLine());
		System.out.println("Su autor:");
		libroNuevo.setAutor(scan.nextLine());
		System.out.println("Numero de paginas que tendra:");
		libroNuevo.setNum_pag(scan.nextInt());
		
		return libroNuevo;
	}
}
