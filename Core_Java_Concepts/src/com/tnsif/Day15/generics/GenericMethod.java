package com.tnsif.Day15.generics;

public class GenericMethod {
	public <E> void displayArrayElements(E[] elements) {
		for (E element : elements) {
			System.out.println("element is: " + element);
		}
	}
}
