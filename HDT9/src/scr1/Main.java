import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in); 
        String fileName = "Spanish.txt"; // nombre del archivo que se va a leer

        System.out.println("Bienvenido a su diccionario Ingles Espanol");
        System.out.println("¿Con que tipo de arbol desea realizar sus consultas?\n(1) Red Black Tree \n(2) Splay Tree \n(3) Binary Search Tree \nIngrese el numero ");
        int treeType = in.nextInt();
        in.nextLine();  
        LeerArchivo<Palabra> lector = new LeerArchivo<Palabra>(treeType); // Creación de clase lector de libro que crea los arboles
        lector.leerArchivo(fileName); // Se lee el archivo y se crea el arbol binario específicado
              
        String menu = "Bienvenido a su diccionario Ingles Espanol\nQue desea realizar: \n1. Buscar traduccion de palabras. \n2.Traducir lineas de texto. \n3. Salir ";
        System.out.println(menu);
        int opcion = in.nextInt(); 
        in.nextLine();
        while(opcion < 3){
            switch (opcion){
                case 1:{ // Se ingresa la palabra y se traduce a los otros dos idiomas
                    System.out.println("Ingrese la palabra en ingles que desea traducir ");
                    String palabra = in.nextLine();
                    palabra.toLowerCase();
                    System.out.println("La palabra "+palabra+ " traducida al espanol es: ");
                    Palabra mibusqueda = lector.getArbol().get(new Palabra(palabra, ""));
                    System.out.println(mibusqueda.getSpanish());
                    break;
                }

                case 2:{
                    // Se solicita una línea y se traduce cada palabra
                    String filename1 = "Lineas.txt";
                    System.out.println("A continuacion se presenta un listado de las lineas a imprimir, ingrese el numero de la linea que desea traducir");
                    LeerArchivo.imprimirLineas(filename1);
                    int linea = in.nextInt();
                    in.nextLine();
                    for (String word: LeerArchivo.leerLineas(filename1).get(linea-1)) {
                        // Comparamos cada palabra con la llave del árbol binario
                        Palabra mibusqueda = lector.getArbol().get(new Palabra(word, ""));
                        if (mibusqueda != null) {
                            System.out.print(mibusqueda.getSpanish() + " ");
                        } else {
                            // De lo contrario, imprimimos la palabra encerrada en asteriscos
                            System.out.print("*" + word + "* ");
                        }
                    }
                    break;
                }

            }
            System.out.println(menu);
            System.out.println("Ingrese la opcion que desea: ");
            opcion = in.nextInt();
            in.nextLine();
        }
    }
}

