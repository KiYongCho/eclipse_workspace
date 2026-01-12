package io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

public class FileTest {
	
	public static void main(String[] args) {
		
		// 파일 객체 생성
		File dir = new File("D:/pub2511/files/dir");
		
		// 디렉토리 생성
		dir.mkdir();
		
		// 디렉토리 여부 확인
		System.out.println(dir.isDirectory());
		
		// 파일 여부 확인
		System.out.println(dir.isFile());
		
		// 디렉토리내에 파일 생성
		File file = new File(dir, "newFile.txt"); // 파일 객체 생성
		try {
			file.createNewFile(); // 파일 생성
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		// 실습 : newFile.txt 파일에 ABC라는 문자열 쓰고 읽어서 화면에 출력
		Writer fw = null;
		Reader fr = null;
		try {
			
			fw = new FileWriter(file);
			fw.write("ABC");
			fw.flush();
			
			fr = new FileReader(file);
//			System.out.println((char)fr.read());
//			System.out.println((char)fr.read());
//			System.out.println((char)fr.read());
			int i;
			while ((i=fr.read()) > -1) {
				System.out.println((char)i);
			}
			
			// 파일의 문자 수
			System.out.println(file.length());
			
			try {
				
				System.out.println(file.canExecute()); // 실행가능 여부
				System.out.println(file.canRead()); // 읽기가능 여부
				System.out.println(file.canWrite()); // 쓰기가능 여부
				
				// 파일의 절대경로를 반환 (.까지)
				System.out.println(new File(".").getAbsolutePath());
				// 파일의 절대경로를 반환 (.제외)				
				System.out.println(new File(".").getCanonicalPath());
				
				System.out.println(file.getName()); // 파일명
				System.out.println(file.getParent()); // 상위 파일 문자열 반환
				System.out.println(file.getParentFile()); // 상위 파일 File객체 반환
				File parentFile = file.getParentFile();
				System.out.println(parentFile.getClass().getName());
				
				System.out.println(file.getPath()); // 파일 경로
				
				System.out.println(file.isHidden()); // 숨김파일 여부
				System.out.println(file.lastModified()); // 최종수정일시에 대한 epoch time 값
				System.out.println(new Date(file.lastModified()));
				
				file.setExecutable(true); // 실행가능여부 설정
				file.setLastModified(System.currentTimeMillis()); // 최종수정일시 설정
				file.setReadable(true); // 읽기가능여부 설정
				file.setReadOnly(); // 읽기 전용 설정
				file.setWritable(true); // 쓰기가능여부 설정
				
				// 파일명 변경
				//file.renameTo(new File("D:/pub2511/files/dir/newnewfile.txt"));
				File f = new File("D:/pub2511/files/dir/srcfile.txt");
				f.createNewFile();
				Path src = Paths.get("D:/pub2511/files/dir/srcfile.txt");
				Path dest = Paths.get("D:/pub2511/files/dir/destfile.txt");
				Files.move(src, dest, StandardCopyOption.REPLACE_EXISTING);	
				
				// 파일 삭제
				File f2 = new File("D:/pub2511/files/dir/destfile.txt");
				if (f2.exists()) { // 파일이 존재하면
					f2.delete();
				}
				
				// listFiles메소드를 사용해 디렉토리내의 파일과 디렉토리 목록 출력
				File dir2 = new File("D:/");
				File[] fileArr = dir2.listFiles(); // 디렉토리내의 파일과 디렉토리 배열
				for (File f3 : fileArr) {
					if (f3.isDirectory()) { // 디렉토리이면
						System.out.println("[D] " + f3.getName() + " (" + f3.length() + ")");
					} else { // 파일이면
						System.out.println(f3.getName() + " (" + f3.length() + ")");
					}
				}
				
				// 루트디렉토리 배열
				File[] rootArr = File.listRoots();
				for (File f4 : rootArr) {
					System.out.println(f4.getPath());
				}
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fr.close();
				fw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	} // main

} // class





































