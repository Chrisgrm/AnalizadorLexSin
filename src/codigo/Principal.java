package codigo;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java_cup.runtime.Symbol;

public class Principal {
	public static void main(String[] args) throws Exception {
        String ruta1 = "C:/Users/chris/Documents/NetBeansProjects/AnalizadorLexico2/src/codigo/Lexer.flex";
        String ruta2 = "C:/Users/chris/Documents/NetBeansProjects/AnalizadorLexico2/src/codigo/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "C:/Users/chris/Documents/NetBeansProjects/AnalizadorLexico2/src/codigo/Sintax.cup"};
        generar(ruta1, ruta2, rutaS);   	

   	NewJFrame analizador = new NewJFrame();
        analizador.setVisible(true);
	}
	  	
   	//----------------------------

	public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
            File archivo;
            archivo = new File(ruta1);
            JFlex.Main.generate(archivo);
            archivo = new File(ruta2);
            JFlex.Main.generate(archivo);
            java_cup.Main.main(rutaS);
            
            Path rutaSym = Paths.get("C:/Users/chris/Documents/NetBeansProjects/AnalizadorLexico2/src/codigo/sym.java");
            if (Files.exists(rutaSym)) {
                Files.delete(rutaSym);
            }
            Files.move(
                    Paths.get("C:/Users/chris/Documents/NetBeansProjects/AnalizadorLexico2/sym.java"), 
                    Paths.get("C:/Users/chris/Documents/NetBeansProjects/AnalizadorLexico2/src/codigo/sym.java")
            );
            Path rutaSin = Paths.get("C:/Users/chris/Documents/NetBeansProjects/AnalizadorLexico2/src/codigo/Sintax.java");
            if (Files.exists(rutaSin)) {
                Files.delete(rutaSin);
            }
            Files.move(
                    Paths.get("C:/Users/chris/Documents/NetBeansProjects/AnalizadorLexico2/Sintax.java"), 
                    Paths.get("C:/Users/chris/Documents/NetBeansProjects/AnalizadorLexico2/src/codigo/Sintax.java")
            );
        
	}
	}



    