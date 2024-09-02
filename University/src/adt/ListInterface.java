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
public interface ListInterface<T> {
    
    
    void add(T element);
    boolean remove(T element);
   int size();
    boolean isEmpty();
    boolean contains(T element);
    T get(int index);
    int getNumberOfEntries();
    
    void clear();
    void set(int index, T element);
    
    
    
    
}
