package com.tnsif.Day19;

public class LambdaExpWithoutParameter {

	public static void main(String[] args) {

		IStatement s = () -> {return "Hello World!!";};
		System.out.println(s.show());

	}

}
