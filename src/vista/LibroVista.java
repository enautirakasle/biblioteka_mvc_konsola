package vista;

import java.util.ArrayList;

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
}
