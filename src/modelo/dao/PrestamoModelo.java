package modelo.dao;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Conector;
import modelo.bean.Libro;
import modelo.bean.Prestamo;
import modelo.bean.Socio;
import vista.LibroVista;
import vista.PrestamoVista;
import vista.SocioVista;

public class PrestamoModelo extends Conector {

	
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
	

	public ArrayList<Prestamo> noDevueltos(String dniS){
		ArrayList<Prestamo> noDevueltos = new ArrayList<Prestamo>();
		try {
			PreparedStatement pst = super.conexion.prepareStatement("SELECT prestamos.*, libros.titulo, libros.autor, libros.num_pag, socios.nombre, socios.apellido, socios.dni, socios.direccion, socios.poblacion, socios.provincia FROM (prestamos join libros on prestamos.id_libro=libros.id) JOIN socios ON prestamos.id_socio=socios.id WHERE socios.dni = ? AND devuelto=false");
			pst.setString(1, dniS);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Libro libro = new Libro();
				libro.setTitulo(rs.getString("libros.titulo"));
				libro.setAutor(rs.getString("libros.autor"));
				libro.setNum_pag(rs.getInt("libros.num_pag"));
				
				Socio socio = new Socio();
				socio.setDni(rs.getString("socios.dni"));
				socio.setDireccion(rs.getString("socios.direccion"));
				socio.setPoblacion(rs.getString("socios.poblacion"));
				socio.setProvincia(rs.getString("socios.provincia"));
				
				Prestamo prestamo = new Prestamo();
				prestamo.setDevuelto(rs.getBoolean("devuelto"));
				prestamo.setFecha(rs.getDate("fecha"));
				prestamo.setLibro(libro);
				prestamo.setSocio(socio);
				
				noDevueltos.add(prestamo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noDevueltos;
	}
	
	public ArrayList<Prestamo> prestamosDeSocio(String dni){
		ArrayList<Prestamo> prestamosDeSocio = new ArrayList<Prestamo>();
		try {
			
			PreparedStatement pst = super.conexion.prepareStatement("SELECT prestamos.*, libros.titulo, libros.autor, libros.num_pag, socios.nombre, socios.apellido, socios.dni, socios.direccion, socios.poblacion, socios.provincia FROM (prestamos join libros on prestamos.id_libro=libros.id) join socios on prestamos.id_socio=socios.id where socios.dni = ?");
			pst.setString(1, dni);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Libro libro = new Libro();
				libro.setTitulo(rs.getString("libros.titulo"));
				libro.setAutor("libros.autor");
				libro.setNum_pag(rs.getInt("libros.num_pag"));
				
				Socio socio = new Socio();
				socio.setNombre(rs.getString("socios.nombre"));
				socio.setApellido(rs.getString("socios.apellido"));
				socio.setDni(rs.getString("socios.dni"));
				socio.setDireccion(rs.getString("socios.direccion"));
				socio.setPoblacion(rs.getString("socios.poblacion"));
				socio.setProvincia(rs.getString("socios.provincia"));

				Prestamo prestamo = new Prestamo();
				prestamo.setDevuelto(rs.getBoolean("prestamos.devuelto"));
				prestamo.setFecha(rs.getDate("prestamos.fecha"));
				prestamo.setLibro(libro);
				prestamo.setSocio(socio);
				
				prestamosDeSocio.add(prestamo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prestamosDeSocio;
	}
	
	public ArrayList<Libro> librosPrestadosASocio(String dni){
		ArrayList<Libro> librosPrestados = new ArrayList<Libro>();
		try {
			PreparedStatement pst = super.conexion.prepareStatement("SELECT libros.* FROM (prestamos join libros on prestamos.id_libro=libros.id) join socios on prestamos.id_socio=socios.id where socios.dni=?");
			pst.setString(1, dni);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				ArrayList <Prestamo>prestamosSocio = selectAll();
				Libro libro = new Libro();
				libro.setId(rs.getInt("libros.id"));
				libro.setTitulo(rs.getString("libros.titulo"));
				libro.setAutor(rs.getString("libros.autor"));
				libro.setNum_pag(rs.getInt("libros.num_pag"));
				libro.setPrestamos(prestamosSocio);
				
				librosPrestados.add(libro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return librosPrestados;
	}
	
	public ArrayList<Socio> sociosQueHanLeido(String titulo){
		ArrayList <Socio> sociosQueHanLeido = new ArrayList<Socio>();
		try {
			PreparedStatement pst = super.conexion.prepareStatement("SELECT socios.* FROM (prestamos join libros on prestamos.id_libro=libros.id) join socios on prestamos.id_socio=socios.id where libros.titulo = ?");
			pst.setString(1, titulo);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				ArrayList <Prestamo> prestamos = selectAll();
				Socio socio = new Socio();
				socio.setId(rs.getInt("socios.id"));
				socio.setNombre(rs.getString("socios.nombre"));
				socio.setApellido(rs.getString("socios.apellido"));
				socio.setDireccion(rs.getString("socios.direccion"));
				socio.setPoblacion(rs.getString("socios.poblacion"));
				socio.setProvincia(rs.getString("socios.provincia"));
				socio.setDni(rs.getString("socios.dni"));
				socio.setPrestamos(prestamos);
				
				sociosQueHanLeido.add(socio);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sociosQueHanLeido;
	}
	
	public void insertar(Prestamo prestamo) {
		try {
			
			PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO prestamos(id_libro, id_socio, fecha, devuelto) VALUES (?, ?, ?, ?)");
			
			
			pst.setInt(1, prestamo.getLibro().getId());
			pst.setInt(2, prestamo.getSocio().getId());
			pst.setDate(3, prestamo.getFecha());
			pst.setBoolean(4, prestamo.isDevuelto());
			
			pst.execute();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void devolverPrestamo(Prestamo prestamo) {
		
		try {
			
			
			PreparedStatement pst = super.conexion.prepareStatement("UPDATE prestamos SET devuelto=? WHERE id_libro=? and id_socio=?");
			
			pst.setBoolean(1, prestamo.isDevuelto());
			pst.setInt(2, prestamo.getLibro().getId());
			pst.setInt(3, prestamo.getSocio().getId());
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Libro> infoDeLibro() {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		try {
			PreparedStatement pst = super.conexion.prepareStatement("SELECT libros.*, prestamos.devuelto FROM libros JOIN prestamos ON libros.id = prestamos.id_libro GROUP BY id_libro");
			ResultSet res = pst.executeQuery();
			while(res.next()) {
				ArrayList <Prestamo> prestamos = selectAll();
				
				Libro libro = new Libro();
				libro.setId(res.getInt("libros.id"));
				libro.setTitulo(res.getString("libros.titulo"));
				libro.setAutor(res.getString("libros.autor"));
				libro.setNum_pag(res.getInt("libros.num_pag"));
				libro.setPrestamos(prestamos);
				
				libros.add(libro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return libros;
	}

	/**
	 * 
	 * @param id es el id de un libro
	 * @return prestamos de ese libro con la información del socio de cada prestamo
	 */
	public ArrayList<Prestamo> prestamosDeLibro(int id) {
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		try {
			PreparedStatement pst = this.conexion.prepareStatement(""
					+ "SELECT prestamos.*, "
					+ "libros.titulo, libros.autor, libros.num_pag, "
					+ "socios.nombre, socios.apellido, socios.dni, socios.direccion, socios.poblacion, socios.provincia "
					+ "FROM (prestamos join libros on prestamos.id_libro=libros.id) "
					+ "join socios on prestamos.id_socio=socios.id "
					+ "where libros.id= ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				Prestamo prestamo = new Prestamo();
				prestamo.setFecha(rs.getDate("fecha"));
				prestamo.setDevuelto(rs.getBoolean("devuelto"));
				
				Socio socio = new Socio();
				socio.setNombre(rs.getString("socios.nombre"));
				socio.setApellido(rs.getString("socios.apellido"));
				socio.setDni(rs.getString("socios.dni"));
				//TODO podriamos poner todos los atributos del socio
				
				prestamo.setSocio(socio);
				
				prestamos.add(prestamo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prestamos;
	}
}
