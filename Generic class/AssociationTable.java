package Q1;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class AssociationTable<K extends Comparable<K>, V> {
 
    private TreeMap<K, V> treemap;
    
    //makes an empty constructor
    public AssociationTable() {
        treemap = new TreeMap<K, V>();
    }
    
    //Makes a constructor if two variables one key one value 
    public AssociationTable(K[] key, V[] value) throws IllegalArgumentException  {
    	 if (key.length != value.length) {
             throw new IllegalArgumentException("error: got keys array and values array of a different length");
         }
         treemap = new TreeMap<K,V>();
         for (int i = 0; i < key.length; i++) {
             treemap.put(key[i], value[i]);
         }
    }
    
    //Adds value to the tree
    public void add(K key, V value) {
    	treemap.put(key, value);
    }
    
    //Returns a value requested by the key
    public V get(K key) {
    	return treemap.get(key);
    }
    
    //Returns true if there is a value in the country otherwise false
    public boolean contains(K key) {
    	return treemap.containsKey(key);
    }
    
    //Deletes a value from the tree
    public boolean remove(K key) {
    	if(this.contains(key)) {
    		treemap.remove(key);
    		return true ;
    	}
    	return false;
    }
    
    //Returns the size of the tree (number of leaves)
    public int size() {
    	return treemap.size();
    }
    
    //return iterator
    public Iterator<Map.Entry<K,V>> keyIterator() {
        return treemap.entrySet().iterator();
    } 
}
