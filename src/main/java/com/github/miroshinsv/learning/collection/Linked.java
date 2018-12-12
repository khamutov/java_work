package com.github.miroshinsv.learning.collection;

import java.util.*;

public class Linked<T> implements List {
    private static Linked first;
    private int size;

    private Linked next;
    private Object value;

    public Linked(){
        first = this;
        this.next = null;
    }

    private Linked(Object o){
        this.value = o;
    }

    private Object getValue() {
        return value;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Linked temp = first;
        while (temp.next !=null){
            if (temp.getValue().equals(o)){
                return true;
            }
            temp = next;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        Iterator iterator = new Iterator() {
            int count =0;
            Linked temp = first;
            @Override
            public boolean hasNext() {
                return size > count;
            }

            @Override
            public Object next() {
                count++;
                return temp.next;
            };
        };
        return iterator;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        if (o == null) return false;

        Linked temp = first;

        while (temp.next != null){
            temp = temp.next;
        }
        temp.value = (T) o;
        temp.next = new Linked(o);
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null){
            return false;
        }
        if (first.getValue().equals(o)){
            --size;
            first = next;
            return true;
        }

        Linked temp = first;
        while (temp.next != null){
            if (temp.next.getValue().equals(o)){
                --size;
                if (temp.next.next == null) {
                    temp.next = null;
                    return true;
                } else {
                    temp.next = temp.next.next;
                    return true;
                }
            }
            temp = temp.next;
        }

        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        if (index > size-1) throw new IndexOutOfBoundsException();
        int counter = 0;
        Linked temp = first;
        while (counter != index){
            counter++;
            temp = temp.next;
        }
        return temp.getValue();
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {
        if (index > size-1){
            throw new IndexOutOfBoundsException();
        }
        Linked temp = first;
        int count = 0;
        while (index!=count){
            temp = next;
            count++;
        }
        temp.value = (T) element;
    }

    @Override
    public Object remove(int index) {
        if (index>size-1){throw new IndexOutOfBoundsException();}
        --size;
        if (index == 0) {
            first = next;
            return true;
        }
        int count =1;
        Linked temp = first;
        while (count!=index){
            temp = next;
        }
        if (temp.next.next == null) {
            temp.next = null;
            return true;
        } else {
            temp.next = temp.next.next;
            return true;
        }
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
