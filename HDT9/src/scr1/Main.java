import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in); 
        String fileName = "texto.txt"; // nombre del archivo


        String menu = "Bienvenido a su diccionario\nQue desea realizar: \n1. Buscar traduccion de palabras. \n2. Recorrer diccionario (in-Order).\n3. Traducir lineas de texto. \n4. Salir ";
        System.out.println(menu);
        int opcion = in.nextInt(); 
        in.nextLine();
        while(opcion < 4){
            switch (opcion){
                case 1:{ // Se ingresa la palabra y se traduce a los otros dos idiomas
                    System.out.println("En que diccionario se encuentra su palabra: 1. Ingles 2. Espaniol 3. Frances (ingrese el numero)");
                    int tipodic = in.nextInt();
                    in.nextLine();
                    System.out.println("Ingrese la palabra que desea traducir. (En minuscula)");
                    String palabra = in.nextLine();
                    // Retorno 
                    System.out.println("La palabra "+palabra+ " traducida es:");
                    System.out.println(dic.Idioma(tipodic, palabra));
                    break;
                }

                case 2:{ // Se solicita un diccionario y se recorre en orden 
                    System.out.println("Que diccionario desea recorrer: 1. Ingles 2. Espaniol 3. Frances (ingrese el numero)");
                    int tipodic = in.nextInt();
                    in.nextLine();
                    dic.tipoArbol(tipodic).InOrderTraversal(visitor);
                    String resultado = visitor.getResult();
                    System.out.println(resultado);
                    break;
                }

                case 3:{ // Se solicita una línea y se traduce cada palabra
                    String filename1 = "Lineas.txt";
                    System.out.println("A continuacion se presenta un listado de las lineas a imprimir, ingrese el numero de la linea que desea traducir");
                    LeerArchivo.imprimirLineas(filename1);
                    int linea = in.nextInt();
                    in.nextLine();
                    System.out.println("Que idioma se esta usando en la linea: 1. Ingles 2. Espaniol 3. Frances (ingrese el numero)");
                    int tipodic = in.nextInt();
                    in.nextLine();
                    System.out.println("A que idioma desea traducir la linea: 1. Ingles 2. Espaniol 3. Frances (ingrese el numero)");
                    int idioma = in.nextInt();
                    in.nextLine();
                    dic.TraduccionDeLineas(LeerArchivo.leerLineas(filename1).get(linea-1), tipodic, idioma);
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

