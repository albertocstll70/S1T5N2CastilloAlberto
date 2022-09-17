package s1t5n2exercici1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class MainExercici3 {

	public static void main(String[] args) {

		String nombreDir = System.getProperty("user.dir");

		ListAlfa3 list1 = new ListAlfa3(nombreDir);

		try {
			list1.listar();
//			list1.leerArchivo(System.getProperty("user.dir") + File.separator + "src" + File.separator + "s1t5n2exercici1"
//					+ File.separator+"result.txt");
		} catch (IOException e) {

			System.err.println("No se encontro el directorio");
		}

		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "s1t5n2exercici1"
				+ File.separator + "result.txt";
		File archivo = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator
				+ "s1t5n2exercici1" + File.separator + "archivo.properties");

		try (OutputStream salida = new FileOutputStream(archivo)) {
			Properties propiedades = new Properties();

			propiedades.setProperty("Directorio", path);
			propiedades.setProperty("Archivo", "result.txt");

			propiedades.store(salida, "**********Archivo de configuracion*************");

		} catch (IOException e) {

			System.out.println("ERROR " + e.getMessage());

		}

	}

}
