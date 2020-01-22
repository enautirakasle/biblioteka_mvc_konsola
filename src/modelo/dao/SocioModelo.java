package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Conector;
import modelo.bean.Socio;

public class SocioModelo extends Conector{
	public ArrayList<Socio> mostrarSocios(){
		ArrayList <Socio> socios = new ArrayList<Socio>();
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM SOCIOS");
			while(rs.next()) {
				Socio socio = new Socio();
				socio.setId(rs.getInt("id"));
				socio.setNombre(rs.getString("nombre"));
				socio.setApellido(rs.getString("apellido"));
				socio.setDireccion(rs.getString("direccion"));
				socio.setPoblacion(rs.getString("poblacion"));
				socio.setProvincia(rs.getString("provincia"));
				socio.setDni(rs.getString("dni"));
				
				socios.add(socio);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return socios;
	}
	
	public Socio mostrarSocio(String dni) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("SELECT * FROM socios WHERE dni = " + dni);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Socio socio = new Socio();
				socio.setId(rs.getInt("id"));
				socio.setNombre(rs.getString("nombre"));
				socio.setApellido(rs.getString("apellido"));
				socio.setDireccion(rs.getString("direccion"));
				socio.setPoblacion(rs.getString("poblacion"));
				socio.setDni(rs.getString("dni"));
				
				return socio;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Socio> buscarPorCaracter(char caracter) {
		ArrayList<Socio> sociosPorLetra = new ArrayList<Socio>();
		try {
			PreparedStatement pst = super.conexion.prepareStatement("SELECT * FROM socios WHERE nombre LIKE ? OR apellido LIKE ?");
			
			pst.setString(1, "%"+caracter+"%");
			pst.setString(2, "%"+caracter+"%");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Socio socio = new Socio();
				socio.setId(rs.getInt("id"));
				socio.setNombre(rs.getString("nombre"));
				socio.setApellido(rs.getString("apellido"));
				socio.setDireccion(rs.getString("direccion"));
				socio.setPoblacion(rs.getString("poblacion"));
				socio.setDni(rs.getString("dni"));
				
				sociosPorLetra.add(socio);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sociosPorLetra;
	}
	
	public void editarSocio(String dniCambiar, String direccionCambiar, String poblacionCambiar, String provinciaCambiar) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("UPDATE socios SET direccion = ?, poblacion = ?, provincia = ? WHERE dni = ?");
			pst.setString(1, direccionCambiar);
			pst.setString(2, poblacionCambiar);
			pst.setString(3, provinciaCambiar);
			pst.setString(4, dniCambiar);
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void borrarSocio(String dniBorrar) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("DELETE FROM socios WHERE dni = ?");
			pst.setString(1, dniBorrar);
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertarSocio(Socio nuevoSocio) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("INSERT INTO socios (nombre, apellido, direccion, poblacion, provincia ,dni) VALUES (?,?,?,?,?,?)");
			pst.setString(1, nuevoSocio.getNombre());
			pst.setString(2, nuevoSocio.getApellido());
			pst.setString(3, nuevoSocio.getDireccion());
			pst.setString(4, nuevoSocio.getPoblacion());
			pst.setString(5, nuevoSocio.getProvincia());
			pst.setString(6, nuevoSocio.getDni());
			System.out.println(nuevoSocio.getPoblacion());
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
