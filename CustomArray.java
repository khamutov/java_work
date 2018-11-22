import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomArray<T> implements List {
    private int capacity;
    private int size;
    private T[] list;

    public CustomArray(int capacity){
        this.capacity = capacity;
        list = (T[])new Object[capacity];
        size = 0;
    }

    public CustomArray(){
        this.capacity = 10;
        list = (T[])new Object[capacity];
        size = 0;
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
        for (T t : list){
            if (t.equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        Iterator iterator = new Iterator() {
            int counter = 0;
            @Override
            public boolean hasNext() {
                return size > counter;
            }

            @Override
            public Object next() {
                if (hasNext()) return list[counter];
                return null;
            }
        };
        return iterator;
    }

    @Override
    public Object[] toArray() {
        Object[] temp = new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = list[i];
        }
        return temp;
    }

    @Override
    public boolean add(Object o) {
        if (size == capacity){
            list = (T[])new Object[capacity + (capacity/2)];
        }
        list[size] =(T)o;
        size++;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        boolean found =false;
        Object[] temp = new Object[capacity -1];
        int count =0;
        for (T t : list){
            if (t.equals(o) && !found){
                found = true;
                continue;
            }
            temp[count] = o;
        }
        return found;
    }

    @Override
    public boolean addAll(Collection c) {
        if (c.size() > size) {
//            copy array
            this.capacity = c.size();
            list = (T[]) new Object[capacity];
            for (int i = 0; i < capacity; i++) {
                list[i] = (T)c.toArray()[i];
            }
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        this.capacity = 10;
        list = (T[]) new Object[capacity];
    }

    private void checkSize(int index){
        if (index > size) throw  new IndexOutOfBoundsException();
    }

    @Override
    public Object get(int index) {
        checkSize(index);
        return list[index];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {
        checkSize(index);
        list[index] = (T) element;
    }

    @Override
    public Object remove(int index) {
        checkSize(index);
        list[index] = null;
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
