package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectTest2 {
	
	public static void main(String[] args) {
		
		// 직렬화할 객체 생성
		Animal dog1 = new Dog("치와와", 4, "왈왈");
		Animal dog2 = new Dog("셰퍼드", 4, "멍멍");
		
		File file = new File("D:/pub2511/files/object2.dat");
		
		// 객체를 바이트단위로 출력하는 스트림
		ObjectOutputStream oos = null;
		// 객체에서 바이트단위로 입력받는 스트림
		ObjectInputStream ois = null;
		
		try {
			
			oos = new ObjectOutputStream(new FileOutputStream(file));
			
			// 직렬화 : 객체(메모리) > 스트림
			oos.writeObject(dog1);
			oos.writeObject(dog2);
			oos.flush();
			
			ois = new ObjectInputStream(new FileInputStream(file));
			
			// 역직렬화 : 스트림 > 객체(메모리)
			Animal a1 = (Dog)ois.readObject();
			System.out.println(a1);
			Animal a2 = (Dog)ois.readObject();
			System.out.println(a2);
			
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				//ois.close();
				oos.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}		
		
	}

}
