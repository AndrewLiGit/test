package com.briup.chap07;

import java.lang.reflect.*;

public class ReflectionTest {
	public static void printField(Class c) {
		Field[] fields = c.getDeclaredFields();
		String modifier;
		String typeName;
		String fieldName;
		for(int i=0;i<fields.length;i++) {
			modifier = Modifier.toString(fields[i].getModifiers());
			fieldName = fields[i].getName();
			typeName = fields[i].getType().getName();
			System.out.println(modifier+" "+typeName+" "+fieldName+";");
		}
	}
	public static void printConstructor(Class c) {
	}
	public static void printMethod(Class c) {
	}
	public static void main(String args[])throws Exception {
//		if(args.length == 0) {
//			System.out.println("please input class name");
//			System.exit(1);
//		}
		String className ;
		Class c = Class.forName("com.briup.chap07.ExecDemo");
		String modifier = Modifier.toString(c.getModifiers());
		className = c.getName();
		System.out.println(modifier+" class "+className+" {");

		printField(c);
		printConstructor(c);
		printMethod(c);
		System.out.println("}");
	}
}
