package gson.ex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

// [ExGson1.java - Gson 변환 실습 1]
// https://jsonplaceholder.typicode.com/posts 에서 JSON문자열을 수신하여
// List에 저장한 후 id값에 대해 내림차순 정렬해서 화면 출력

public class ExGson1 {

	public static void main(String[] args) {

		String uriStr = "https://jsonplaceholder.typicode.com/posts";

		try {

			URLConnection conn = new URI(uriStr).toURL().openConnection();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String jsonStr = "";
			String line = "";
			while ((line = br.readLine()) != null) {
				jsonStr += line;
			}

			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			List<Post> postList 
				= gson.fromJson(jsonStr, new TypeToken<List<Post>>() {}.getType());

			Collections.sort(postList, new Comparator<Post>() {
				@Override
				public int compare(Post post1, Post post2) {
					return post2.getId() - post1.getId();
				}
			});
			
			postList.stream().forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}

	} // main

}