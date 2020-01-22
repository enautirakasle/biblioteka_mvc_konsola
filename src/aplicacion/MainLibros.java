package aplicacion;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.bean.Libro;
import modelo.bean.Usuario;
import modelo.dao.LibroModelo;
import vista.LibroVista;

public class MainLibros {
	static final int SALIR = 1;
	static final int MOSTRAR_LIBROS = 2;
	static final int MOSTRAR_LIBRO = 3;
	static final int BUSCAR = 4;
	static final int MOSTRAR_LIBROS_LARGOS = 5;
	static final int EDITAR_PAGINAS_LIBRO = 6;
	static final int ELIMINAR_LIBRO = 7;
	static final int CREAR_LIBRO = 8;
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		LibroModelo lModelo;
		LibroVista lVista;
		int opcion;
		do {
			menuDeOpciones();
			opcion = scan.nextInt();
			
			switch (opcion) {
			case SALIR:
				System.out.println("Saliendo del programa..");
				break;
				
			case MOSTRAR_LIBROS:
				lModelo = new LibroModelo();
				lVista = new LibroVista();
				ArrayList <Libro> libros = lModelo.selectAll();
				lVista.imprimirLibros(libros);
				break;
			
			case MOSTRAR_LIBRO:
				lModelo = new LibroModelo();
				System.out.println("Escribe el titulo del libro que quieres mostrar");
				String titulo = new Scanner(System.in).nextLine();
				Libro libro = lModelo.select(titulo);
				System.out.println(libro);
				
				break;
				
			case BUSCAR:
				lModelo = new LibroModelo();
				lVista = new LibroVista();
				System.out.println("Escribe un string, y te saldran las peliculas que contengan esas letras en su titulo");
				String parteTitulo = new Scanner(System.in).nextLine();
				ArrayList <Libro> librosPorTitulo = lModelo.busquedaPorTitulo(parteTitulo);
				lVista.imprimirPorTitulo(librosPorTitulo);
				
				break;
				
			case MOSTRAR_LIBROS_LARGOS:
				lModelo = new LibroModelo();
				lVista = new LibroVista();
				System.out.println("Escribe un numero de paginas, para mostrar los libros que tengan mas paginas que esas");
				int numDePaginas = scan.nextInt();
				ArrayList <Libro> librosLargos = lModelo.librosGordos(numDePaginas);
				lVista.imprimirLibrosMasLargos(librosLargos);
				break;
				
			case EDITAR_PAGINAS_LIBRO:
				lModelo = new LibroModelo();
				System.out.println("Escribe id de libro, del cual quieres cambiar su autor y numero de paginas");
				int idUpdate = scan.nextInt();
				System.out.println("Escribe su nuevo autor");
				String autor = new Scanner(System.in).nextLine();
				System.out.println("Y su numero de paginas");
				int num_paginas = new Scanner(System.in).nextInt();
				
				Libro libroCambiado = new Libro();
				libroCambiado.setId(idUpdate);
				libroCambiado.setAutor(autor);
				libroCambiado.setNum_pag(num_paginas);
				lModelo.update(libroCambiado);
				break;
				
			case ELIMINAR_LIBRO:
				System.out.println("Escribe el id de libro para borrar");
				int idDelete = scan.nextInt();
				lModelo = new LibroModelo();
				lModelo.delete(idDelete);
				break;
				
			case CREAR_LIBRO:
				lVista = new LibroVista();
				lModelo = new LibroModelo();
				Libro libroNuevo = lVista.getLibro();
				lModelo.insertLibro(libroNuevo);
			default:
				break;
			}
		} while (opcion != SALIR);
		
		

	}
	
	public static void menuDeOpciones() {
		
		
		System.out.println(SALIR + ". Salir");
		System.out.println(MOSTRAR_LIBROS + ". Mostrar libros");
		System.out.println(MOSTRAR_LIBRO + ". Mostrar libro");
		System.out.println(BUSCAR + ". Buscar por nombre");
		System.out.println(MOSTRAR_LIBROS_LARGOS + ". Mostrar libros largos");
		System.out.println(EDITAR_PAGINAS_LIBRO + ". Editar");
		System.out.println(ELIMINAR_LIBRO + ". Eliminar libro");
		System.out.println(CREAR_LIBRO + ". crear libro");
	}
}
