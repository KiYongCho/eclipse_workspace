// 원격 JSON서버에서 JSON문자열을 가져와서 파싱

package gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GsonTest2 {
	
	public static void main(String[] args) {
		
		String uriStr = "https://jsonplaceholder.typicode.com/posts";
		
		try {
			
			// 1. 원격서버에서 데이터 가져오기
			URLConnection conn = new URI(uriStr).toURL().openConnection();
			
			if (conn!=null) {
				
				BufferedReader br = new BufferedReader(
					new InputStreamReader(conn.getInputStream())
				);
				
				String jsonStr = "";
				String lineStr = "";
				
				while ((lineStr=br.readLine()) != null) {
					jsonStr += lineStr;
				}
				
				// 2. 가져온 JSON문자열을 List로 변환 후 출력
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				List<Post> postList
					= gson.fromJson(
							jsonStr, 
							new TypeToken<List<Post>>() {}.getType()
						);
				// postList.stream().forEach(System.out::println);
				
				// 실습 : 가져온 JSON문자열을 Map으로 변환 후 출력
				//         키:id의 값, 값:post객체
//				Map<Integer, Post> postMap = postList.stream()
//	                .collect(Collectors.toMap(
//	                        Post::getId, // id
//	                        Function.identity() // 입력한 값을 그대로 반환하는 함수
//	                ));
//				postMap.entrySet()	.stream().forEach(
//					entry -> System.out.println(entry.getKey() + ":" + entry.getValue())
//                );
				String jsonMapStr = "{\"key\":" + jsonStr + "}";
				Map<String, List<Post>> postMap2 
					= gson.fromJson(
							jsonMapStr, 
							new TypeToken<Map<String, List<Post>>>(){}.getType()
						);
				postMap2.get("key").stream().forEach(System.out::println);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // main

} // class

























