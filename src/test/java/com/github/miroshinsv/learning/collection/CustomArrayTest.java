package com.github.miroshinsv.learning.collection;

import static org.junit.Assert.*;
import org.junit.Test;

public class CustomArrayTest {

    private CustomArray instance = new CustomArray<Integer>();

    @Test
    public void testAdd() {
        instance.add(1);
        assertEquals(1, instance.get(0));
    }

    @Test
    public void testContainsWithNull() {
        instance.add(1);
        instance.add(null);
        assertFalse(instance.contains(2));
    }

    @Test
    public void testContainsNull() {
        instance.add(1);
        assertFalse(instance.contains(null));
    }

    @Test
    public void testArrayWithNullContainsNull() {
        instance.add(null);
        assertTrue(instance.contains(null));
    }

    @Test
    public void testCheckArray(){
        instance.add(1);
        assertEquals(instance.size(),1);
    }

    @Test
    public void testCheckArraySeveral(){
        instance.add(1);
        instance.add(2);
        assertEquals(instance.size(),2);
    }

    @Test
    public void testIsEmpty(){
        assertTrue(instance.isEmpty());
    }

    @Test
    public void testIsNotEmpty(){
        instance.add(1);
        assertFalse(instance.isEmpty());
    }

    @Test
    public void testToArray(){
        instance.add(1);
        instance.add(2);
        instance.add(3);
        assertEquals(new Object[]{1,2,3},instance.toArray());
    }

    @Test
    public void testRemove(){
        instance.add(1);
        instance.add(2);
        instance.add(3);
        instance.remove((Object) 1);
        assertEquals(new Object[]{2,3},instance.toArray());
    }

    @Test
    public void testRemoveNull(){
        instance.add(1);
        instance.add(2);
        instance.add(3);
        instance.remove(null);
        assertEquals(new Object[]{1,2,3},instance.toArray());
    }
}
