import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import java.lang.Exception;
import structure5.*;

/**
 * @author Sharis Barrios
 *
 */
public class Pruebas {

	@Test
	public void InsertionRedBlackTree() {
		RedBlackSearchTree<Palabra> miDiccionario = new RedBlackSearchTree<Palabra>();
		
		miDiccionario.add(new Palabra("dog", "perro"));
		miDiccionario.add(new Palabra("house", "casa"));
		miDiccionario.add(new Palabra("window", "ventana"));
		
		Palabra miBusqueda = miDiccionario.get(new Palabra("house", ""));
		
		assertEquals("house", miBusqueda.getEnglish());
		assertEquals("casa", miBusqueda.getSpanish());
		
	}

    @Test
    public void InsertionRedBlackTreeNull() {
		RedBlackSearchTree<Palabra> miDiccionario = new RedBlackSearchTree<Palabra>();
		
		miDiccionario.add(new Palabra("dog", "perro"));
		miDiccionario.add(new Palabra("house", "casa"));
		miDiccionario.add(new Palabra("window", "ventana"));
		
		assertEquals(null, miDiccionario.get(new Palabra("woman", "")));
		
	}

    @Test
    public void testGetBinarySearchTree() {
        BinarySearchTree<Palabra> miDiccionario = new BinarySearchTree<Palabra>();
        miDiccionario.add(new Palabra("dog", "perro"));
		miDiccionario.add(new Palabra("house", "casa"));
		miDiccionario.add(new Palabra("window", "ventana"));
		
		assertEquals(null, miDiccionario.get(new Palabra("house", "")));
		
    }



} 
