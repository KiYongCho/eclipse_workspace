package gson.ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

//[ExGson2.java - Gson 변환 실습 2]
// https://jsonplaceholder.typicode.com/users
// https://jsonplaceholder.typicode.com/todos
// 사용자별 todo의 전체개수와 완료한 todo의 개수를 아래 형식으로 todocount.log 파일에 저장
// 파일 출력 형식 : 사용자명 [전체todo수:00개, 완료todo수:00개]

public class ExGson2 {

	public static void main(String[] args) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		List<User> userList = gson.fromJson(getJsonStr("https://jsonplaceholder.typicode.com/users"),
				new TypeToken<List<User>>() {
				}.getType());

		List<Todo> todoList = gson.fromJson(getJsonStr("https://jsonplaceholder.typicode.com/todos"),
				new TypeToken<List<Todo>>() {
				}.getType());

		Map<Object, String> resultMap = new HashMap<Object, String>();

		File file = new File("D:\\pub2511\\files\\todocount.log");
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(file));
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Object user : userList) {
			int todoCount = 0;
			int completedCount = 0;
			int userId = ((User) user).getId();
			for (Object todo : todoList) {
				if (String.valueOf(userId).equals(((Todo)todo).getUserId())) {
					resultMap.put("name" + userId, ((User) user).getUsername());
					resultMap.put("total" + userId, String.valueOf(++todoCount));
					if (((Todo) todo).getCompleted()) {
						resultMap.put("complete" + userId, String.valueOf(++completedCount));
					}
				}
			}
			try {
				bw.write(resultMap.get("name" + userId) 
						+ " [전체todo수:" + resultMap.get("total" + userId) 
						+ "개, 완료todo수:" + resultMap.get("complete" + userId) + "개]\r\n");
				bw.flush();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} // for

	} // main

	private static String getJsonStr(String uriStr) {
		String totalLine = "";
		try {
			URL url = new URI(uriStr).toURL();
			URLConnection conn = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			while ((line = br.readLine()) != null) {
				totalLine += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalLine;
	}

} // class
