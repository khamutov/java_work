package com.github.miroshinsv.learning.collection;

import java.util.*;

public class CustomArray<T> implements List {
    private int capacity;
    private int size;
    T[] t;

    public CustomArray(int capacity) {
        this.capacity = capacity;
        t = (T[]) new Object[capacity];
        this.size = 0;
    }

    public CustomArray() {
        this.capacity = 10;
        t = (T[]) new Object[capacity];
        this.size = 0;
    }


    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        if(o == null){
            for (int i = 0; i < size; i++) {
                if (t[i] == null) {
                    return true;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (t[i] == null){
                    if (t[i] == o) {
                        return true;
                    }
                }else if (t[i].equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        Iterator iterator = new Iterator() {
            int count =-1;
            @Override
            public boolean hasNext() {
                return size < count;
            }

            @Override
            public Object next() {
                count++;
                return t[count];
            }
        };
        return iterator;
    }

    @Override
    public Object[] toArray() {
        Object[] objects =new Object[size];
        for (int i = 0; i < size; i++) {
            objects[i] = t[i];
        }
        return objects;
    }

    @Override
    public boolean add(Object o) {
        if (size >= capacity) {
            t = (T[]) new Object[capacity + capacity/2];
        }
        t[size] = (T) o;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        boolean found = false;
        if(o == null){
            for (int i = 0; i < size; i++) {
                if (t[i] == null & t[i] == o && !found) {
                    found = true;
                    continue;
                }
                if (found){
                    t[i-1] = t[i];
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (t[i].equals(o) && !found){
                found = true;
                continue;
            }
            if (found){
                t[i-1] = t[i];
            }
        }
        if (found){size--;}
        return found;
    }

    @Override
    public boolean addAll(Collection c) {
        if (c.size() > size){
            t = (T[]) new Object[capacity + capacity/2 + c.size()];
        }
        c.forEach(val->{
            t[size+1]  =(T) val;
            size++;
        });
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        this.capacity = 10;
        t = (T[]) new Object[capacity];
    }

    @Override
    public Object get(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        return t[index];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
