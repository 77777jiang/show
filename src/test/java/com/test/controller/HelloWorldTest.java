package com.test.controller;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {
    @Test
    public  void testhello(){
        HelloWorld helloWorld = new HelloWorld();
        String comment = helloWorld.hello();
        assertEquals("success",comment);
    }
}
