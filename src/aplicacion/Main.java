package aplicacion;

import java.util.ArrayList;
import java.util.Scanner;

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
				Usuario usuario = uVista.getUsuario();
				uModelo = new UsuarioModelo();
				
				//TODO jonek egiteko
				uModelo.insert(usuario);
				
				break;
			case VER_USUARIOS:
				uModelo = new UsuarioModelo();
				ArrayList<Usuario> usuarios  = uModelo.selectAll();
				UsuarioVista.imprimir(usuarios);
				
				break;
			case VER_USUARIO:
				//TODO jonek egiteko VER_USUARIOS funtzionalitatean oinarrituta
				

				break;
			case CAMBIAR_PASSWORD_USAURIO:
				//TODO jonek egiteko
				//erabiltzaile dni-a eskatu
				
				//pasaihtz zaharra eskatu
				
				//pasahitz berria sartzeko esan
				
				//erabiltzailea aldatu datu basean
				
			
				break;
			case ELIMINAR_USUARIO:
				//TODO jonek egiteko
				//dnia eskatu
				//konfirmazioa eskatu
				//	baietz bada ezabatu
				//	bestela ez ezabatu
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
