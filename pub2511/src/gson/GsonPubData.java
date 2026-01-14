// data.go.kr
// 국토교통부_공동주택 단지 목록제공 서비스
// https://apis.data.go.kr/1613000/AptListService3/getSidoAptList3?serviceKey=zdcLWo1S7NHYWqvcfEoiha9REwwXCbFApvxzGS7jvyb72D3x4UASxWn3uKv%2FcVa2aEkk5Yc8X2mwsBAlN2GvKQ%3D%3D&sidoCode=27&pageNo=1&numOfRows=10

package gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class GsonPubData {
	
	private static final String SERVICE_KEY = "zdcLWo1S7NHYWqvcfEoiha9REwwXCbFApvxzGS7jvyb72D3x4UASxWn3uKv%2FcVa2aEkk5Yc8X2mwsBAlN2GvKQ%3D%3D";
	private static final String SIDO_CODE = "11";
	private static final String PAGE_NO = "1";
	private static final String NUM_OF_ROWS = "10000";
	private static final String END_POINT
		= "https://apis.data.go.kr/1613000/AptListService3/getSidoAptList3?"
			+ "serviceKey=" + SERVICE_KEY
			+ "&sidoCode=" + SIDO_CODE 
			+ "&pageNo=" + PAGE_NO
			+ "&numOfRows=" + NUM_OF_ROWS;
	
	public static void main(String[] args) {
		
		try {
			
			URLConnection conn = new URI(END_POINT).toURL().openConnection();
			
			if (conn!=null) {
				
				BufferedReader br = new BufferedReader(
					new InputStreamReader(conn.getInputStream())
				);
				String jsonStr = "";
				String lineStr = "";
				while((lineStr=br.readLine()) != null) {
					jsonStr += lineStr;
				}
				
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				
				JsonObject jsonObject = gson.fromJson(jsonStr, JsonObject.class);
				JsonObject response = jsonObject. getAsJsonObject("response");
				JsonObject body = response.getAsJsonObject("body");
				JsonArray items = body.getAsJsonArray("items");

				List<Item> itemList = gson.fromJson(
					items, 
					new TypeToken<List<Item>>() {}.getType()
				);
				
				
				itemList.stream().forEach(item -> {
					System.out.printf(
						"아파트코드:%s, 아파트명:%s, 도로명주소:%s %s %s\n", item.getKaptCode(), 
						item.getKaptName(), item.getAs1(), item.getAs2(), item.getAs3()
					);
				});
				
				System.out.println("총 데이터 건수 : " + itemList.size());
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // main
	
} // class

























