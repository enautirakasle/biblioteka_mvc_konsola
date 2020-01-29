package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import modelo.Conector;
import modelo.bean.Libro;
import modelo.bean.Prestamo;
import modelo.bean.Socio;
import modelo.bean.Usuario;

public class LibroModelo extends Conector{
	
	public ArrayList<Libro> selectAll(){
		
	ArrayList <Libro> libros = new ArrayList<Libro>();
	try {
		Statement st = super.conexion.createStatement();
		ResultSet rs = st.executeQuery("select * from libros");
		while(rs.next()){
			Libro libro = new Libro();
			libro.setId(rs.getInt("id"));
			libro.setTitulo(rs.getString("titulo"));
			libro.setAutor(rs.getString("autor"));
			libro.setNum_pag(rs.getInt("num_pag"));
			
			libros.add(libro);
		}
		return libros;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return libros;
	}
	
	
	public Libro select(String titulo) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from libros where titulo = ?");
			pst.setString(1, titulo);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				Libro libro = new Libro();
				libro.setId(rs.getInt("id"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setAutor(rs.getString("autor"));
				libro.setNum_pag(rs.getInt("num_pag"));
				
				return libro;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete(int id) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("delete from libros where id = ?");
			pst.setInt(1, id);
			pst.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Libro libro) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("update libros set autor = ?, num_pag = ? where id = ?");
			pst.setString(1, libro.getAutor());
			pst.setInt(2, libro.getNum_pag());
			pst.setInt(3, libro.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Libro> librosGordos(int numDePaginas) {
		
		ArrayList<Libro> librosMasLargos = new ArrayList<Libro>();
		try {
			Statement st = super.conexion.createStatement();
			
			ResultSet res = st.executeQuery("select * from  libros where num_pag > " + numDePaginas);
			while(res.next()) {
				Libro libro = new Libro();
				libro.setId(res.getInt("id"));
				libro.setTitulo(res.getString("titulo"));
				libro.setAutor(res.getString("autor"));
				libro.setNum_pag(res.getInt("num_pag"));
				
				librosMasLargos.add(libro);			
				}
			return librosMasLargos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return librosMasLargos;
		
		
	}
	
	public ArrayList<Libro> busquedaPorTitulo(String parteTitulo) {
		ArrayList<Libro> librosPorTitulo = new ArrayList <Libro>();
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from libros where titulo like '%"+parteTitulo+"%'");
			while (rs.next()) {
				Libro libro = new Libro();
				libro.setId(rs.getInt("id"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setAutor(rs.getString("autor"));
				libro.setNum_pag(rs.getInt("num_pag"));
				
				librosPorTitulo.add(libro);
			}
			return librosPorTitulo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return librosPorTitulo;
	}
	
	public void insertLibro(Libro libroNuevo) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO libros (titulo, autor, num_pag) VALUES (?,?,?)");
			pst.setString(1, libroNuevo.getTitulo());
			pst.setString(2, libroNuevo.getAutor());
			pst.setInt(3, libroNuevo.getNum_pag());
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Libro> selectAllConPrestamos(){
		ArrayList<Libro> libros = this.selectAll();
		PrestamoModelo prestamoModelo = new PrestamoModelo();
		
		Iterator<Libro> i = libros.iterator();
		while(i.hasNext()){
			Libro libro = i.next();
			libro.setPrestamos(prestamoModelo.prestamosDeLibro(libro.getId()));
		}
		
		return libros;
	}
}
