package com.tnsif.Day19;

public class WithoutLambdaExp {

	public static void main(String[] args) {
		//without lambda, 
    	//Message implementation using anonymous class  
     
        IStatement s=new IStatement() {
        	public String show()
        	{
        		return "Welcome to Lambda Expression";
        	}};
        	
        	System.out.println(s.show());

	}

}
