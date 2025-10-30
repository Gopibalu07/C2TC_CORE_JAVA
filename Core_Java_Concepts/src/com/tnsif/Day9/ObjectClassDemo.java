package com.tnsif.Day9;

class Sample {

}

class Demo {
	public Demo() {
		// resource allocate
		System.out.println("In Constructor");
	}

	@Override
	protected void finalize() throws Throwable {
		// resource cleanup code
		System.out.println("In Finalize");
	}

}

public class ObjectClassDemo {

	public static void main(String[] args) {
		ObjectClassDemo s = new ObjectClassDemo();
		ObjectClassDemo s1 = new ObjectClassDemo();
		System.out.println(s.getClass().getName());
		System.out.println(s.hashCode());
		System.out.println(s1.hashCode());
		Demo d = new Demo();
		System.out.println(d.hashCode());
		Demo d1=d;
		//Demo d1 = new Demo();
		System.out.println(d1.hashCode());
		d = null;
		System.gc();
		System.out.println(d1);
		
	

	}
}
