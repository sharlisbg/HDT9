/**
 * @author: Sharis Barrios
 * Clase Factory para decidir que tipo de árbol utilizar
 */
public class Factory {
    public static IEstructuraArbol<Palabra> createArbol(int treeType) {
        switch (treeType) {
            case 1:{ //Red and Balck
                return new ArbolRedBlack<Palabra>();
            }
            case 2:{ // Splay Tree
                return new ArbolSplay<Palabra>();
            }

            case 3:{ // Binary Tree
                return new ArbolBinarySearch<Palabra>();
            }

            default:{
                throw new IllegalArgumentException("Tipo de árbol desconocido");
            }
        }
    }
}

