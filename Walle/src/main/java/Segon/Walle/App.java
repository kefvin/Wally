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
public class App 
{
	private final static String CADENAATROBAR = "Wally";
    public static void main( String[] args )throws IOException
    {
    	// expresión regular a usar = \WWally\W
    	
    	BufferedReader br = new BufferedReader( new InputStreamReader(
    			App.class.getResource("text.txt").openStream()));
    	
    	String linia;
    	int total = 0;
    	int guarda = 0;
    	
    	try{
    	while((linia = br.readLine()) != null){
    		
			int compta = buscar(linia);
			guarda += compta;
			
			if (guarda > 1){
				throw new FitxerIncorrecteException();
			}else{
				total += guarda;
			}
			
		}
    	
    	System.out.println("Imprimir la fila y la columna en la que aparece Wally ");
    	
    	}catch (Exception e){
    		System.out.println(e);
    	}catch (FitxerIncorrecteException fie){
    		System.out.println(fie.massaWally());
    	}
    }
    
	private static int buscar(String linia) throws FitxerIncorrecteException {
		// Con esa expresión aceptaría -Wally- y no debería comprobar excepciones de caracteres especiales
		String find = "\\W"+CADENAATROBAR+"\\W";
		
		//Matcher es donde buscar y pattern es la expresión regular que busco
		Pattern p = Pattern.compile(find);
		Matcher m = p.matcher(linia);
		
		int compta = 0; 
		
		while(m.find()){
			compta++;
		}
		
		// Si hay más de 1 match FITXER INCORRECTE
		return compta;
	}
}
