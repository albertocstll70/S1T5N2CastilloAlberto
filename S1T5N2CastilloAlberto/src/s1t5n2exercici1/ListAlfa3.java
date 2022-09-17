package s1t5n2exercici1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ListAlfa3 {
	private String dir;

	public ListAlfa3(String dir) {
		this.dir = dir;

	}

	// método lista el contenido del directorio, subdirectorios y fecha de
	// modificación en orden alfabético
	public void listar() throws IOException {
		File[] result = null;

		File directorio = new File(this.dir);
		if (!directorio.exists()) {
			throw new IOException();
		} else {

			result = directorio.listFiles();
			Arrays.sort(result);

			String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "s1t5n2exercici1"
					+ File.separator;
			long date;
			DateFormat formato = new SimpleDateFormat("MMM dd, yyyy hh:mm a");

			for (File f : result) {

				if (f.isDirectory()) {
					date = f.lastModified();

					escribir("D: " + f.getAbsolutePath() + "  ultima modificación --> " + formato.format(date) + "\n",
							path + "result.txt");

					this.dir = (String) f.getPath();

					listar();
				} else if (f.isFile()) {
					date = f.lastModified();

					escribir("F: " + f.getAbsolutePath() + "  ultima modificación --> " + formato.format(date) + "\n",
							path + "result.txt");

				}

			}

		}
	}

	// método que escribe en un archivo
	public void escribir(String contenido, String path) {

		try (BufferedWriter escribiendo = new BufferedWriter(new FileWriter(path, true))) {

			escribiendo.write(contenido);
			escribiendo.newLine();

			// System.out.println(contenido);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void leerArchivo(String path) {

		try (FileReader entrada = new FileReader(path)) {

			BufferedReader leer = new BufferedReader(entrada);

			String linea = "";
			String i = "1";
			int y = 1;
			while (linea != null) {

				linea = leer.readLine();
				if (linea != null) {

					System.out.println(linea);
				}
				y++;
				i = i + y;
			}

		} catch (IOException e) {

			System.out.println(" No se encontro el archivo");
		}

	}

}
