package com.briup.chap07;

public class ExceptionTest {
	public static void main(String args[]) throws Exception {
		int num1;
		int num2;
		int result;
		try{
			num1 = 12;
			num2 = 0;
			if(num2 == 0)
				throw new Exception("this is Zero");
			result = num1/num2;
			System.out.println("result:"+result);
		}
		catch(NumberFormatException e){
			System.out.println("number format exception!");
		}
		catch(Exception e){
			System.out.println("num2 can not be zero!");
			//e.printStackTrace();
			System.out.println("e.getMessage():"+e.getMessage());
			System.exit(0);
		}
		finally{
			System.out.println("release connection");
		}
		System.out.println("Exception test!");
	}
}
