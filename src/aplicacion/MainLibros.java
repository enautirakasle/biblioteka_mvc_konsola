package aplicacion;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.bean.Libro;
import modelo.bean.Usuario;
import modelo.dao.LibroModelo;

public class MainLibros {
	static final int SALIR = 1;
	static final int MOSTRAR_LIBROS = 2;
	static final int MOSTRAR_LIBRO = 3;
	static final int BUSCAR = 4;
	static final int MOSTRAR_LIBROS_LARGOS = 5;
	static final int EDITAR_PAGINAS_LIBRO = 6;
	static final int ELIMINAR_LIBRO = 7;
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		LibroModelo lModelo;
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
				ArrayList <Libro> libros = lModelo.selectAll();
				lModelo.imprimirLibros(libros);
				break;
			
			case MOSTRAR_LIBRO:
				lModelo = new LibroModelo();
				System.out.println("Escribe el titulo del libro que quieres mostrar");
				String titulo = new Scanner(System.in).nextLine();
				Libro libro = lModelo.select(titulo);
				System.out.println(libro);
				
				break;
				
			case BUSCAR:
				/*lo que me da error al ejecutar
				 * 
				 
				lModelo = new LibroModelo();
				System.out.println("Escribe un nombre, para listar los libros que contengan ese nombre en su titulo");
				String nombre = new Scanner(System.in).nextLine();
				lModelo.busquedaPorTitulo(nombre);
				break;*/
				
			case MOSTRAR_LIBROS_LARGOS:
				/* lo que me da error al ejecutar
				 * 
				lModelo = new LibroModelo();
				System.out.println("Escribe un numero de paginas, para mostrar los libros con mas paginas de lo que has escrito");
				int numDePaginas = new Scanner(System.in).nextInt();
				lModelo.librosGordos(numDePaginas);
				break;*/
				
			case EDITAR_PAGINAS_LIBRO:
				System.out.println("Escribe id de libro, del cual quieres cambiar su autor y numero de paginas");
				int idUpdate = scan.nextInt();
				System.out.println("Escribe su nuevo autor");
				String autor = new Scanner(System.in).nextLine();
				System.out.println("Y su numero de paginas");
				int num_paginas = new Scanner(System.in).nextInt();
				
				lModelo = new LibroModelo();
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
	}
}
