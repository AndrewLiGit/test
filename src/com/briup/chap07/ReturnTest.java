package com.briup.chap07;

public class ReturnTest {
	private static int i ;
	public static int getReturn1(){
		try{
			System.out.println("in getReturn1()");
			i = Integer.parseInt("a");
			return 10;
		}catch(NumberFormatException e) {
			try{
				System.out.println("try()");
			}catch(Exception e2) {}
		}
			return 20;
	}
	public static int getReturn2() {
		try{
			return 10;
		}finally{
			return 20;
		}
	}
	public static void main(String args[]) {
		int return1 = getReturn1();
		System.out.println("return1:"+return1);
		int return2 = getReturn2();
		System.out.println("return2:"+return2);
	}
}
