package modelo.dao;

import java.lang.reflect.Array;
import java.util.ArrayList;

import modelo.bean.Libro;
import modelo.bean.Prestamo;
import modelo.bean.Socio;

public class PrestamoModelo {
	private ArrayList<Prestamo> prestamos;

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}
	
	public ArrayList<Prestamo> selectAll(){
		
		return prestamos;
	}
	
	public void cargarDatos() {
		
	}
	
	public ArrayList<Prestamo> noDevueltos(){
		
		return prestamos;
	}
	
	public ArrayList<Socio> prestamosDeSocio(String dni){
		ArrayList<Socio> socios = new ArrayList<Socio>();
		return socios;
	}
	
	public ArrayList<Libro> librosPrestadosASocio(String dni){
		ArrayList<Libro> libros = new ArrayList<Libro>();
		return libros;
	}
	
	public ArrayList<Socio> sociosQueHanLeido(String titulo){
		ArrayList<Socio> socios = new ArrayList<Socio>();
		return socios;
	}
	
	public void insertar(Prestamo prestamo) {
		
	}
	
	public void finalizar(Prestamo prestamo) {
		
	}
}
