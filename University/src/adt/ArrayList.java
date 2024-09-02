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
public class ArrayList<T> implements ListInterface<T>{
    
     private T[] value;
    private int numberOfEntries; 
    private final int DEFAULT_CAPACITY=5;
    
    
    public ArrayList(){
        numberOfEntries=0;
        value=(T[])new Object[DEFAULT_CAPACITY];
    }
    
    public ArrayList(int capacity){
        numberOfEntries=0;
        value=(T[])new Object[capacity];
    }
    
    
    //List Start 
    @Override
    public void add(T element) {
      if (numberOfEntries == value.length) {
            // RenumberOfEntries the array if it's full
            renumberOfEntriesArray(value.length * 2);
        }
        value[numberOfEntries] = element;
        numberOfEntries++;
        
        
    }

    @Override
    public boolean remove(T element) {
      for (int i = 0; i < numberOfEntries; i++) {
            if (value[i].equals(element)) {
                // Shift elements to fill the gap
                for (int j = i; j < numberOfEntries - 1; j++) {
                    value[j] = value[j + 1];
                }
                value[numberOfEntries - 1] = null; // Clear the last element
                numberOfEntries--;
                return true;
            }
        }
        return false;
    }

   
    
    @Override
    public int getNumberOfEntries() {
      return numberOfEntries;
    }

    
    @Override
    public boolean isEmpty() {
      return numberOfEntries == 0;
    }

    public int size(){
        return numberOfEntries;
    }
    
    @Override
    public boolean contains(T element) {
        
       for (int i = 0; i < numberOfEntries; i++) {
            if (value[i].equals(element)) {
                return true;
            }
        }
        return false;
    }
    public void clear() {
    numberOfEntries = 0;
    }
    public T get(int index) {
        
      if (index < 0 || index >= numberOfEntries) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return value[index];
    }
    
     private void renumberOfEntriesArray(int newCapacity) {
        T[] newArray = (T[])new Object[newCapacity];
        System.arraycopy(value, 0, newArray, 0, numberOfEntries);
        value = newArray;
    }
     
     public String toString() {
       String str="[";
    
    boolean isFirst = true;
    for (int i = 0; i < numberOfEntries; i++) {
        if (value[i] != null) {
            if (!isFirst) {
                str+=",";
            }
            str+=value[i];
            isFirst = false;
        }
    }
    
    return str;
    }

     public void set(int index, T element) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        
        // Replace the element at the specified index with the new element
        value[index] = element;
    }
     
     
}
