/*
	Gson
	  - Google에서 만든 Java-JSON 변환 라이브러리
	  - toJson() : 자바객체 > JSON문자열
	  - fromJaon() : JSON문자열 > 자바객체
*/

package gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class GsonTest1 {
	
	public static void main(String[] args) {
		
		// Gson 객체 생성법 1
		Gson gson1 = new Gson();
		
		// Gson 객체 생성법 2
		Gson gson2 = new GsonBuilder().create();
		
		// Gson 객체 생성법 3 : JSON문자열에 들여쓰기 적용
		Gson gson3 = new GsonBuilder().setPrettyPrinting().create();
		
		// JsonObject 객체 생성
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name", "홍길동");
		jsonObject.addProperty("age", "30");
		
		// JsonObject를 JSON문자열로 변경
		String jsonObjectStr = gson3.toJson(jsonObject);
		System.out.println(jsonObjectStr);
		
		// JSON문자열을 JsonObject로 변경
		JsonObject jsonObject2 
			= gson3.fromJson(jsonObjectStr, JsonObject.class);
		System.out.println(jsonObject2);
		
		// Java객체를 JSON문자열로 변경
		Person person = new Person("홍길동", 30);
		String personJsonStr = gson3.toJson(person);
		System.out.println(personJsonStr);
		
		// JSON문자열을 Java객체로 변경
		Person person2 = gson3.fromJson(personJsonStr, Person.class);
		System.out.println(person2);
		
		// List객체를 JSON문자열로 변경
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("홍길동", 30));
		personList.add(new Person("강감찬", 40));
		personList.add(new Person("이순신", 50));
		String jsonListStr = gson3.toJson(personList);
		System.out.println(jsonListStr);
		
		// JSON문자열을 List객체로 변경
		List<Person> personList2
			= gson3.fromJson(
					jsonListStr,
					new TypeToken<ArrayList<Person>>() {}.getType()
				);
		System.out.println(personList2);
		
		// Map객체를 JSON문자열로 변경
		Map<String, String> personMap
			= new HashMap<String, String>();
		personMap.put("name", "유관순");
		personMap.put("age", "20");
		personMap.put("gender", "여성");
		String mapStr = gson3.toJson(personMap);
		System.out.println(mapStr);
		
		// JSON문자열을 Map객체로 변경
		Map<String, String> personMap2
			= gson3.fromJson(
					mapStr,
					new TypeToken<HashMap<String, String>>() {}.getType()
				);
		System.out.println(personMap2);
		
	}

}














