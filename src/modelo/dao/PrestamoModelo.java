package modelo.dao;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Conector;
import modelo.bean.Libro;
import modelo.bean.Prestamo;
import modelo.bean.Socio;
import vista.PrestamoVista;

public class PrestamoModelo extends Conector {
	private ArrayList<Prestamo> prestamos;

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}
	
	public ArrayList<Prestamo> selectAll(){
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT prestamos.*, libros.titulo, libros.autor, libros.num_pag, socios.nombre, socios.apellido, socios.dni, socios.direccion, socios.poblacion, socios.provincia FROM (prestamos JOIN libros ON prestamos.id_libro=libros.id) JOIN socios ON prestamos.id_socio=socios.id");
			
			while(rs.next()) {
				Prestamo prestamo = new Prestamo();
				Libro libro = new Libro();
				
				libro.setTitulo(rs.getString("libros.titulo"));
				libro.setAutor(rs.getString("libros.autor"));
				libro.setNum_pag(rs.getInt("libros.num_pag"));
				
				Socio socio = new Socio();
				socio.setNombre(rs.getString("socios.nombre"));
				socio.setApellido(rs.getString("socios.apellido"));
				socio.setDni(rs.getString("socios.dni"));
				socio.setDireccion(rs.getString("socios.direccion"));
				socio.setPoblacion(rs.getString("socios.poblacion"));
				socio.setProvincia(rs.getString("socios.provincia"));
				
				prestamo.setDevuelto(rs.getBoolean("devuelto"));
				prestamo.setFecha(rs.getDate("fecha"));
				prestamo.setLibro(libro);
				prestamo.setSocio(socio);
				prestamos.add(prestamo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
