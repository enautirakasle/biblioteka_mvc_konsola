package vista;

import java.lang.reflect.Array;
import java.util.ArrayList;

import modelo.bean.Socio;

public class SocioVista {
	public static void imprimirSocios(ArrayList<Socio> socios) {
		for (int i = 0; i < socios.size(); i++) {
			Socio socio = socios.get(i);
			System.out.println(socio);
		}
	}
	
	public static void imprimirSociosQueTenganLetra(ArrayList <Socio> sociosPorLetra) {
		for (int i = 0; i < sociosPorLetra.size(); i++) {
			Socio socio = sociosPorLetra.get(i);
			System.out.println(socio);
		}
	}
}
