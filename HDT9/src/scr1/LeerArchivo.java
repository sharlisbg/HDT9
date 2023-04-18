import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author: Sharis Barrios 
 * Clase de lectura para almacenar diccionario en arboles binarios
 */

public class LeerArchivo<T> {

    private final int SPANISH_INDEX = 1;
    private final int ENGLISH_INDEX = 0;

    /**
     * @param nombreArchivo
     * @param treeType
     * @return IEstructuraArbol<Palabra>
     */
    public IEstructuraArbol<Palabra> leerArchivo(String nombreArchivo, int treeType) {
        IEstructuraArbol<Palabra> arbol = Factory.createArbol(treeType);
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3 && datos[0].equalsIgnoreCase("tree") && datos[1].equalsIgnoreCase("arbol")) {
                    Palabra palabra = new Palabra(datos[ENGLISH_INDEX].trim(), datos[SPANISH_INDEX].trim());
                    arbol.add(palabra);
                }
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arbol;
    }
    /*
    
     * @param filename
     * @return List<List<String>>
     * @throws IOException
    
    // Método para leer y guardar líneas a traducir 
    public static List<List<String>> leerLineas(String filename) throws IOException {
        List<List<String>> lines = new ArrayList<>();
    
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] wordsInLine = line.split(" ");
            List<String> words = new ArrayList<>();
            for (String word : wordsInLine) {
                words.add(word);
            }
            lines.add(words);
        }
        reader.close();
    
        return lines;
    }

    
    /** 
     * @param archivo
    
    // Método para imprimir las líneas de un archivo 
    public static void imprimirLineas(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
          String linea;
          int contador = 1;
          while ((linea = br.readLine()) != null) {
            System.out.println(contador + ": " + linea);
            contador++;
          }
        } catch (IOException e) {
          System.err.println("Error al leer el archivo: " + e.getMessage());
        }
      }
      */
    
}

