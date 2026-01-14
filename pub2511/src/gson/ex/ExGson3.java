package gson.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/*
	[ExGson3.java - Gson 변환 실습 3]
	https://jsonplaceholder.typicode.com/users
	website 주소가 .com으로 끝나는 사용자들의 정보를 출력
*/

public class ExGson3 {

	public static void main(String[] args) {

		BufferedReader br = null;

		try {

			br = new BufferedReader(new InputStreamReader(
					new URI("https://jsonplaceholder.typicode.com/users").toURL().openConnection().getInputStream()));

			String jsonStr = "";
			String line = "";
			while ((line = br.readLine()) != null) {
				jsonStr += line;
			}

			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			List<User> userList = gson.fromJson(jsonStr, new TypeToken<List<User>>() {
			}.getType());

			userList.stream().filter(user -> user.getWebsite().endsWith(".com")).forEach(System.out::println);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

	} // main

} // class
