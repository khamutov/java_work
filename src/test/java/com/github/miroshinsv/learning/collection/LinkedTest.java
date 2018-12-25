package com.github.miroshinsv.learning.collection;

import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertFalse(linked.contains("b"));
    }


}
