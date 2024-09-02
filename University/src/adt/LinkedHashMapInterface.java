/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Gigabyte
 */
public interface LinkedHashMapInterface<K,V> {
    

  void put(K key, V value);

    V get(K key);

    boolean remove(K key);
    boolean containsKey(K keys);
    interface Entry<K, V> {
        K getKey();

        V getValue();
    }
   public void displayValues();
   public void displayKeys();
    public ListInterface<K> getAllKeys();
  
  boolean isEmpty();
    
    int size();
    
    
}
