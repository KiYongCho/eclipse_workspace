package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectTest1 {
	
	public static void main(String[] args) {
		
		// 직렬화할 객체 생성
		Person hong = new Person("홍길동", 20, "123456-1234567");
		Person kang = new Person("강감찬", 30, "234561-2345671");
		
		File file = new File("D:/pub2511/files/object.dat");
		
		// 객체를 바이트단위로 출력하는 스트림
		ObjectOutputStream oos = null;
		// 객체에서 바이트단위로 입력받는 스트림
		ObjectInputStream ois = null;
		
		try {
			
			oos = new ObjectOutputStream(new FileOutputStream(file));
			
			// 직렬화 : 객체(메모리) > 스트림
			oos.writeObject(hong);
			oos.writeObject(kang);
			oos.flush();
			
			ois = new ObjectInputStream(new FileInputStream(file));
			
			// 역직렬화 : 스트림 > 객체(메모리)
			Person h = (Person)ois.readObject();
			System.out.println(h);
			Person k = (Person)ois.readObject();
			System.out.println(k);
			
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















