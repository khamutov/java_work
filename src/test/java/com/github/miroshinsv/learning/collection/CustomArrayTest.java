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
}
