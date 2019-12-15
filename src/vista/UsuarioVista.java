package vista;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.bean.Usuario;

public class UsuarioVista{
	
	
	public static void imprimir(ArrayList<Usuario> usuarios){
		for(int i = 0; i< usuarios.size();i++){
			Usuario usuario = usuarios.get(i);
			System.out.println(usuario);
		}
	}
	
	public static void inprimir(Usuario usuario){
		System.out.println(usuario);
	}

	public Usuario getUsuario() {
		Usuario usuario = new Usuario();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el nombre");
		usuario.setNombre(scan.nextLine());
		
		System.out.println("Introduce el apellido");
		usuario.setApellido(scan.nextLine());
		
		System.out.println("Introduce el dni");
		usuario.setDni(scan.nextLine());
		
		System.out.println("Introduce la contraseña");
		usuario.setPassword(scan.nextLine());
		//TODO pasahitzak 4 karaktere baino gehiago izan behar du.
		//bestela berriro eskatu.
		//TODO jonek egiteko pasahitza bi aldiz eskatu eta ondo badago bakarrik sartu
		//bestela bi pasahitzak berriro eskatu

		
		System.out.println("Será administrador? ('si' o Enter");
		String opcion = scan.nextLine();
		if(opcion.equals("si")){
			usuario.setAdmin(true);
		}else{
			usuario.setAdmin(false);
		}

		return usuario;
	}
}
