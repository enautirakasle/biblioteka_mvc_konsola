package aplicacion;

import java.util.ArrayList;
import java.util.Scanner;

import javax.security.auth.callback.ConfirmationCallback;

import modelo.bean.Usuario;
import modelo.dao.UsuarioModelo;
import vista.UsuarioVista;

public class Main {
	static final int SALIR = 0;
	static final int CREAR_USUARIO = 1;
	static final int VER_USUARIOS = 2;
	static final int VER_USUARIO = 3;
	static final int CAMBIAR_PASSWORD_USAURIO = 4;
	static final int ELIMINAR_USUARIO = 5;

	public static void main(String[] args) {
		
		UsuarioModelo uModelo;
		UsuarioVista uVista;
		
		Scanner scan = new Scanner(System.in);
		
		int aukera;
		do {
			menuPrincipal();

			aukera = Integer.parseInt(scan.nextLine());

			switch (aukera) {
			case CREAR_USUARIO:
				uVista = new UsuarioVista();
				Usuario usuarioNuevo = uVista.getUsuario();
				uModelo = new UsuarioModelo();
				
				
				uModelo.insert(usuarioNuevo);
				
				break;
			case VER_USUARIOS:
				uModelo = new UsuarioModelo();
				ArrayList<Usuario> usuarios  = uModelo.selectAll();
				UsuarioVista.imprimir(usuarios);
				
				break;
			case VER_USUARIO:
				
				System.out.println("Escribe una id de usuario:");
				int id = new Scanner(System.in).nextInt();
				uModelo = new UsuarioModelo();
				Usuario usuario = uModelo.select(id);
				System.out.println(usuario);				
				

				break;
			case CAMBIAR_PASSWORD_USAURIO:
				//TODO jonek egiteko
				//erabiltzaile dni-a eskatu
				
				//pasaihtz zaharra eskatu
				
				//pasahitz berria sartzeko esan
				
				//erabiltzailea aldatu datu basean
				
			
				break;
			case ELIMINAR_USUARIO:
				//falta confirmar borrado
				System.out.println("dni de usuario a borrar:");
				String dni = new Scanner(System.in).nextLine();
				uModelo = new UsuarioModelo();
				uModelo.delete(dni);
				System.out.println("Usuario borrado");
				
				break;
			case SALIR:
				System.out.println("El programa se ha cerrado....");
				break;
			default:
				System.out.println("Opcion incorrecta");
				break;
			}

		} while (aukera != SALIR);

	}

	private static void menuPrincipal() {
		System.out.println(CREAR_USUARIO + "- erabiltzailea sortu");
		System.out.println(VER_USUARIO + "- erabitlzaile bat ikusi");
		System.out.println(VER_USUARIOS + "- erabiltzaile guztiak ikusi");
		System.out.println(CAMBIAR_PASSWORD_USAURIO + "- pasahitza aldatu");
		System.out.println(ELIMINAR_USUARIO + "- erabiltzailea ezabatu");
		System.out.println(SALIR + "- salir");

	}

}
