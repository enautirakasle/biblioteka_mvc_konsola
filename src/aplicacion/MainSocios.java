package aplicacion;

import java.util.Scanner;

public class MainSocios {
	static final int SALIR = 1;
	static final int MOSTRAR_SOCIOS = 2;
	static final int MOSTRAR_SOCIO = 3;
	static final int BUSCAR = 4;
	static final int EDITAR_SOCIO = 5;
	static final int ELIMINAR_SOCIO = 6;
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		int opcion;
		do {
		
			menuPrincipal();
			opcion = scan.nextInt();
			
			switch (opcion) {
			case SALIR:
				System.out.println("Saliendo..");
				break;
			case MOSTRAR_SOCIOS:
				//TODO
				break;
			case MOSTRAR_SOCIO:
				//TODO
				break;
			case BUSCAR:
				//TODO
				break;
			case EDITAR_SOCIO:
				//TODO
				break;
			case ELIMINAR_SOCIO:
				//TODO
				break;
			default:
				break;
			}
		} while (opcion != SALIR);
		
		
	}
	
	public static void menuPrincipal() {
		System.out.println(SALIR + " Salir");
		System.out.println(MOSTRAR_SOCIOS + " Mostrar todos los socios");
		System.out.println(MOSTRAR_SOCIO + " Mostrar un socio");
		System.out.println(BUSCAR + " Buscar por parte del nombre");
		System.out.println(EDITAR_SOCIO + " Editar socio");
		System.out.println(ELIMINAR_SOCIO + " Eliminar socios");
	}
}
