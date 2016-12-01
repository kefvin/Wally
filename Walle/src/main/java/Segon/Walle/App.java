package Segon.Walle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App {
	private final static String CADENAATROBAR = "Wally";
	private static int fila = 0;
	private static int columna = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(App.class.getResource("/text.txt").openStream()));
		
		// expresión regular a usar = [.,\\\s]Wally[.,\\\s]|Wally

				String linia;
				int total = 0;
				int guarda = 0;
				int comptaFiles = 0;

				try {
					while ((linia = br.readLine()) != null) {

						if (guarda > 1) {
							throw new FitxerIncorrecteException();
						} else {
							total += guarda;
							fila = comptaFiles;
						}
						
						int compta = buscar(linia);
						guarda += compta;
						comptaFiles++;
					}
					if(guarda == 0){
						throw new noHiHaWallyException();
					}else{
						System.out.println("En Wally és a la línia "+ fila +" columna "+ columna);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FitxerIncorrecteException e) {
					// TODO Auto-generated catch block
					System.out.println(e.massaWally());
				} catch (noHiHaWallyException e) {
					// TODO Auto-generated catch block
					System.out.println(e.zeroWally());
				}

	}

	private static int buscar(String linia) throws FitxerIncorrecteException {
		// Con esa expresión aceptaría -Wally- y no debería comprobar
		// excepciones de caracteres especiales
		String find = "[.,\\s\\S]" + CADENAATROBAR + "[.,\\s]|Wally";

		// Matcher es donde buscar y pattern es la expresión regular que busco
		Pattern p = Pattern.compile(find);
		Matcher m = p.matcher(linia);

		int compta = 0;

		while (m.find()) {
			String trobat = m.group(0);
			columna = linia.indexOf(trobat);
			compta++;
		}

		// Si hay más de 1 match FITXER INCORRECTE
		return compta;
	}
}
