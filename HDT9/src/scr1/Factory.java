/**
 * @author: Sharis Barrios
 * Clase Factory para decidir que tipo de árbol utilizar
 */
public class Factory<T> {
    public static <T extends Comparable<T>> IEstructuraArbol<T> createArbol(int treeType) {
        switch (treeType) {
            case 1:{ //Red and Balck
                return new ArbolRedBlack<T>();
            }
            case 2:{ // Splay Tree
                return new ArbolSplay<T>();
            }
            default:{
                throw new IllegalArgumentException("Tipo de árbol desconocido");
            }
        }
    }
}

