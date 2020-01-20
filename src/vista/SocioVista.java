package vista;

import java.util.ArrayList;

import modelo.bean.Socio;

public class SocioVista {
	public static void imprimirSocios(ArrayList<Socio> socios) {
		for (int i = 0; i < socios.size(); i++) {
			Socio socio = socios.get(i);
			System.out.println(socio);
		}
	}
}
