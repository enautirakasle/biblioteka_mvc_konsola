package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Conector;
import modelo.bean.Libro;
import modelo.bean.Usuario;

public class LibroModelo extends Conector{
	
	public ArrayList<Libro> selectAll(){
		//TODO
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
	
	
	/*public Libro select(String titulo) {
		//TODO
	}*/
	
	public void delete(int id) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("delete from libros where id = ?");
			pst.setInt(1, id);
			pst.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*public Libro buscar(int id) {
		//TODO
	}*/
	
	/*public Libro buscar (String titulo) {
		//TODO
	}*/
	
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
	
	public void librosGordos(int numPaginas) {
		//TODO
	}
	
	public void busquedaPorTitulo() {
		//TODO
	}
	
	public void busquedaPorTitulo(String parteTitulo) {
		//TODO
	}
	
	public static void imprimirLibros(ArrayList <Libro> libros) {
		for (int i = 0; i < libros.size(); i++) {
			System.out.println(libros.get(i));
		}
	}
}