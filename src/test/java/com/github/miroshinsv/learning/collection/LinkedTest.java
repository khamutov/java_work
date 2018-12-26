package com.github.miroshinsv.learning.collection;

import org.junit.Assert;
import org.junit.Test;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class LinkedTest {
    Linked linked = new Linked();

    @Test
    public void checkSize(){
        linked.add(1);
        Assert.assertEquals(linked.size(),1);
    }

    @Test
    public void checkSeveralSize(){
        linked.add(1);
        linked.add(2);
        Assert.assertEquals(linked.size(),2);
    }

    @Test
    public void checkGetFirst(){
        linked.add(1);
        linked.add(2);
        Assert.assertEquals(linked.get(0),1);
    }

    @Test
    public void checkGetABC(){
        linked.add("a");
        linked.add("b");
        linked.add("c");
        Assert.assertEquals(linked.get(0),"a");
        Assert.assertEquals(linked.get(1),"b");
        Assert.assertEquals(linked.get(2),"c");
    }

    @Test
    public void checkGetSecond(){
        linked.add(1);
        linked.add(2);
        Assert.assertEquals(linked.get(1),2);
    }

    @Test
    public void checkRemoveByObject(){
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.remove("b");
        Assert.assertEquals(linked.get(0),"a");
        Assert.assertEquals(linked.get(1),"c");
    }

    @Test
    public void checkRemoveByObjectFirstItem(){
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.remove("a");
        Assert.assertEquals(linked.get(0),"b");
        Assert.assertEquals(linked.get(1),"c");
    }

    @Test
    public void checkRemoveNull(){
        linked.add("a");
        linked.add(null);
        linked.add("c");
        linked.remove(null);
        Assert.assertEquals(linked.get(0),"a");
        Assert.assertEquals(linked.get(1),"c");
    }


    @Test
    public void checkAddByIndex(){
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.add(0,"c");
        Assert.assertEquals(linked.get(0),"c");
        Assert.assertEquals(linked.get(1),"b");
        Assert.assertEquals(linked.get(2),"c");
    }


    @Test
    public void checkAddNull(){
        linked.add("a");
        linked.add("b");
        linked.add(null);
        linked.add(0,"c");
        Assert.assertEquals(linked.get(0),"c");
        Assert.assertEquals(linked.get(1),"b");
        Assert.assertNull(linked.get(2));
    }


    @Test
    public void checkRemoveByIndex(){
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.remove(1);
        Assert.assertEquals(linked.get(0),"a");
        Assert.assertEquals(linked.get(1),"c");
    }

    @Test
    public void checkRemoveByIndexFirst(){
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.remove(0);
        Assert.assertEquals(linked.get(0),"b");
        Assert.assertEquals(linked.get(1),"c");
    }


    @Test
    public void checkContainsTrue(){
        linked.add("a");
        Assert.assertTrue(linked.contains("a"));
    }


    @Test
    public void checkContainsFalse(){
        linked.add("a");
        assertFalse(linked.contains("b"));
    }

    @Test
    public void checkContainsWithNull() {
        linked.add(null);
        assertTrue(linked.contains(null));
    }

    @Test
    public void checkToArray() {
        linked.add("a");
        linked.add("b");

        Assert.assertArrayEquals(new String[]{"a", "b"}, linked.toArray());
    }

    @Test
    public void checkAddAll() {
        linked.add("a");
        linked.addAll(Arrays.asList("b", "c"));

        assertEquals(3, linked.size());
        assertEquals("a", linked.get(0));
        assertEquals("b", linked.get(1));
        assertEquals("c", linked.get(2));
    }

    @Test
    public void checkAddAllWithIndex() {
        linked.add("a");
        linked.add("d");
        linked.addAll(1, Arrays.asList("b", "c"));

        assertEquals(4, linked.size());
        assertEquals("a", linked.get(0));
        assertEquals("b", linked.get(1));
        assertEquals("c", linked.get(2));
        assertEquals("d", linked.get(3));
    }

    @Test
    public void checkClear() {
        linked.add("a");
        linked.clear();

        assertEquals(0, linked.size());
    }

    @Test
    public void checkSet() {
        linked.add("a");
        linked.set(0, "b");

        assertEquals(1, linked.size());
        assertEquals("b", linked.get(0));
    }

    @Test
    public void checkRemoveByIndexGreaterOne() {
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.remove(2);
        Assert.assertEquals(linked.get(0),"a");
        Assert.assertEquals(linked.get(1),"b");
    }

    @Test
    public void checkIndexOf() {
        linked.add("a");
        linked.add("b");

        assertEquals(1, linked.indexOf("b"));
    }

    @Test
    public void checkLastIndexOf() {
        linked.add("b");
        linked.add("b");

        assertEquals(1, linked.indexOf("b"));
    }
    @Test
    public void checkSublist() {
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.add("d");

        List sublist = linked.subList(1, 2);

        assertEquals(1, sublist.size());
        assertEquals("b", sublist.get(0));
    }

    @Test
    public void checkSublistClear() {
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.add("d");

        linked.subList(1, 2).clear();

        assertEquals(3, linked.size());
        assertEquals("a", linked.get(0));
        assertEquals("c", linked.get(1));
        assertEquals("d", linked.get(2));
    }

    @Test
    public void checkRetainAll() {
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.add("d");

        linked.retainAll(Arrays.asList("b", "c"));

        assertEquals(2, linked.size());
        assertEquals("b", linked.get(0));
        assertEquals("c", linked.get(1));
    }

    @Test
    public void checkRemoveAll() {
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.add("d");

        linked.removeAll(Arrays.asList("b", "c"));

        assertEquals(2, linked.size());
        assertEquals("a", linked.get(0));
        assertEquals("d", linked.get(1));
    }

    @Test
    public void checkContainsAll() {
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.add("d");

        assertTrue(linked.containsAll(Arrays.asList("b", "c")));
        assertFalse(linked.containsAll(Arrays.asList("not_exists", "c")));
    }

    @Test
    public void checkListIterator() {
        linked.add("a");
        linked.add("b");

        ListIterator it = linked.listIterator();

        assertTrue(it.hasNext());
        assertEquals(0, it.nextIndex());
        assertEquals("a", it.next());
        assertTrue(it.hasNext());
        assertEquals(1, it.nextIndex());
        assertEquals("b", it.next());
        assertFalse(it.hasNext());
        assertEquals(2, it.nextIndex());
    }

    @Test
    public void checkListIteratorSetOp() {
        linked.add("a");
        linked.add("b");

        ListIterator it = linked.listIterator();

        assertEquals("a", it.next());
        it.set("c");
        assertEquals("c", linked.get(0));
    }

    @Test
    public void checkListIteratorRemoveOp() {
        linked.add("a");
        linked.add("b");

        ListIterator it = linked.listIterator();

        assertEquals("a", it.next());
        it.remove();
        assertEquals("b", linked.get(0));
    }

    @Test
    public void checkListIteratorAddOp() {
        linked.add("a");
        linked.add("b");

        ListIterator it = linked.listIterator();

        assertEquals("a", it.next());
        it.add("c");
        assertEquals("b", it.next());
        assertEquals("c", linked.get(1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void checkListIteratorPreviousOp() {
        ListIterator it = linked.listIterator();
        it.previous();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void checkListIteratorPreviousIndexOp() {
        ListIterator it = linked.listIterator();
        it.previousIndex();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void checkListIteratorHasPreviousIndexOp() {
        ListIterator it = linked.listIterator();
        it.hasPrevious();
    }
}
