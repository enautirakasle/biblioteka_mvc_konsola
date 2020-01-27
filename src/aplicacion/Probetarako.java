package aplicacion;

import java.util.ArrayList;
import java.util.Iterator;

import modelo.bean.Libro;
import modelo.bean.Prestamo;
import modelo.dao.LibroModelo;
import modelo.dao.PrestamoModelo;
import vista.LibroVista;
import vista.PrestamoVista;

public class Probetarako {

	public static void main(String[] args) {
		PrestamoModelo pm = new PrestamoModelo();
		ArrayList<Prestamo> prestamos1 = pm.selectAll();
		PrestamoVista.imprimirPrestamos(prestamos1);

		LibroModelo lm = new LibroModelo();
		ArrayList<Libro> librosConPrestamos = lm.selectAllConPrestamos();
		// libros1 arrayko liburuak Prestamoak beteta dituzte
		LibroVista.imprimirLibros(librosConPrestamos);

		ArrayList<Libro> libros = lm.selectAll();
		// libros1 arrayko liburuak prestamoak bete gabe dituzte
		LibroVista.imprimirLibros(libros);
		
		//libros arrayko prestamoen datuak bete ditzaket hemen selectAllConPrestamos erabili gabe.
		//PrestamoModelo-ko prestamosDeLibro erabiliko dut
		//azken finean selectAllConPrestamos-ek barruan hori bera egiten du.
		Iterator<Libro> i = libros.iterator();
		while(i.hasNext()){
			Libro libro = i.next();
			
			libro.setPrestamos(pm.prestamosDeLibro(libro.getId()));
			
		}
		LibroVista.imprimirLibros(libros);

	}

}
