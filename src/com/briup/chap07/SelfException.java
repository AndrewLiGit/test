package com.briup.chap07;

class MyException extends Exception {
	public MyException(){}
	public MyException(String msg) {
		super(msg);
	}
}
public class SelfException {
	public static int result;
	public static void main(String args[]) throws MyException {
		assert args.length == 2 : "Error:please input two number!";

		int num1 = 12;
		int num2 = 0;
		
		assert num2==0 : "除数";
//			if(num2 == 0) 
//				throw new MyException("除数不能为0");
		result = num1/num2;
		System.out.println("result:"+result);
	}
}
