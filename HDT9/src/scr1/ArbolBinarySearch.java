import structure5.*;
/**
 * @author: Sharis Barrios 
 *
 */
public class ArbolBinarySearch<T extends Comparable<T>> implements IEstructuraArbol<T> {

	private BinarySearchTree<T> myInternalTree;
	
	public ArbolBinarySearch() {
		myInternalTree = new BinarySearchTree<T>();
	}
	
	
	/** 
	 * @param value
	 */
	@Override
	public void add(T value) {
		myInternalTree.add(value);
	}

	@Override
	public T get(T key) {
		return myInternalTree.get(key);
	}

	@Override
	public T remove(T key) {
		return myInternalTree.remove(key);
	}

	@Override
	public int count() {
		return myInternalTree.size();
	}

	@Override
	public boolean isEmpty() {
		return myInternalTree.isEmpty();
	}
	
	public BinarySearchTree<T> getInternalTree(){
		return myInternalTree;
	}

}
