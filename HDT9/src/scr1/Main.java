import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in); 
        String fileName = "Spanish.txt"; // nombre del archivo que se va a leer

        // Se solicita ingresar el tipo de árbol con el cual se quiere trabajar
        System.out.println("Bienvenido a su diccionario Ingles Espanol");
        System.out.println("¿Con que tipo de arbol desea realizar sus consultas?\n(1) Red Black Tree \n(2) Splay Tree \n(3) Binary Search Tree \nIngrese el numero ");
        int treeType = in.nextInt();
        in.nextLine();  
        LeerArchivo<Palabra> lector = new LeerArchivo<Palabra>(treeType); // Creación de clase lector de libro que crea los arboles
        lector.leerArchivo(fileName); // Se lee el archivo y se crea el arbol binario específicado
              
        String menu = "\nBienvenido a su diccionario Ingles Espanol\nQue desea realizar: \n1. Buscar traduccion de palabras. \n2. Traducir lineas de texto. \n3. Salir ";
        System.out.println(menu);
        int opcion = in.nextInt(); 
        in.nextLine();
        while(opcion < 3){
            switch (opcion){
                case 1:{ // Se ingresa la palabra y se traduce al español
                    System.out.println("Ingrese la palabra en ingles que desea traducir ");
                    String palabra = in.nextLine();
                    palabra = palabra.toLowerCase();
                    System.out.println("La palabra "+palabra+ " traducida al espanol es: ");
                    Palabra mibusqueda = lector.getArbol().get(new Palabra(palabra, ""));
                    System.out.println(mibusqueda.getSpanish());
                    break;
                }

                case 2:{
                    // Se solicita una línea y se traduce cada palabra de la línea
                    String filename1 = "Lineas.txt";
                    System.out.println("A continuacion se presenta un listado de las lineas a imprimir, ingrese el numero de la linea que desea traducir");
                    LeerArchivo.imprimirLineas(filename1);
                    int linea = in.nextInt();
                    in.nextLine();
                    for (String word : LeerArchivo.leerLineas(filename1).get(linea - 1)) { // Por cada palabra en la línea
                        Palabra nueva = new Palabra(word, "");
                        if (lector.getArbol().get(nueva) == null) { // Si la palabra en inglés no está en el arbol está no se traduce
                            System.out.print("*" + word + "* ");
                        } else {
                            Palabra mibusqueda = lector.getArbol().get(nueva); // Si se encuentra en el arbol está si se traduce al español
                            System.out.print(mibusqueda.getSpanish() + " ");
                            
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

