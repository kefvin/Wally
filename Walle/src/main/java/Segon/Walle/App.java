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
    	
    	while((linia = br.readLine()) != null){
    		
			buscar(linia);
			// if compta > 1 || total > 1
			
		}
    }
    
	private static void buscar(String linia) {
		String find = "\\W"+CADENAATROBAR+"\\W";
		
		//Matcher es donde buscar y pattern es la expresión regular que busco
		Pattern p = Pattern.compile(find);
		Matcher m = p.matcher(linia);
		
		int compta = 0; 
		
		while(m.find()){
			compta++;
		}
		// return compta
		
		// Si hay más de 1 match FITXER INCORRECTE
	}
}
