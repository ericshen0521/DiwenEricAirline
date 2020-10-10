package com.flightsearch.test;

import java.util.*;
public class HelloWorld{

     public static void main(String []args) throws CloneNotSupportedException{
        System.out.println("Hello World");
        A a = new A("a");
        System.out.println(a.name);
        A b = (A) a.clone();
        System.out.println(b.name);
        System.out.println(a == b);
     }
}

class A implements Cloneable{
    String name;
    public A(String str) {
        this.name = str;
    }
    @Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}