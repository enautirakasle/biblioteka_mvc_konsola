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
				//TODO
				break;
				
			case BUSCAR:
				//TODO
				break;
				
			case MOSTRAR_LIBROS_LARGOS:
				//TODO
				break;
				
			case EDITAR_PAGINAS_LIBRO:
				//TODO
				break;
				
			case ELIMINAR_LIBRO:
				System.out.println("Escribe el id de libro para borrar");
				int id = scan.nextInt();
				lModelo = new LibroModelo();
				lModelo.delete(id);
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
