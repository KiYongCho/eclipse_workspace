package gson.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
	[ExGson4.java - Gson 변환 실습 4]
	https://newsapi.org/v2/top-headlines?country=us&apiKey=a52463f5568d430891e2595adf958dd4
	뉴스 제목이나 내용에 Trump가 들어간 뉴스 추출 후 출력
*/

public class ExGson4 {

	public static void main(String[] args) {

		BufferedReader br = null;

		try {

			br = new BufferedReader(new InputStreamReader(
					new URI("https://newsapi.org/v2/top-headlines?country=us&apiKey=a52463f5568d430891e2595adf958dd4")
							.toURL().openConnection().getInputStream()));

			String jsonStr = "";
			String line = "";
			while ((line = br.readLine()) != null) {
				jsonStr += line;
			}

			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			News news = gson.fromJson(jsonStr, News.class);

			news.getArticles().stream()
					.filter(article -> article.getTitle().contains("Trump") || article.getContent().contains("Trump"))
					.forEach(System.out::println);

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
