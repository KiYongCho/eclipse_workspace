package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

// 실습 : ssg닷컴의 베스트 상품리스트 크롤링
//         https://www.ssg.com/page/pc/ranking.ssg
//         "[브랜드명] 제품명 가격"의 형태로 출력해 보자

public class CrawlingTest2 {

	public static void main(String[] args) {

		URLConnection conn = null;
		BufferedReader br = null;

		try {
			conn = new URI("https://www.ssg.com/page/pc/ranking.ssg").toURL().openConnection();

			InputStream is = conn.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));

			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append('\n');
			}
			String html = sb.toString();

			// "판매가격"을 기준으로 상품 카드(보통 <a>...</a>) 블록을 잘라내며 순회
			int idx = 0;
			int printed = 0;
			int maxPrint = 50; // 너무 많이 나오면 보기 힘드니 제한

			while (printed < maxPrint) {
				int posPrice = html.indexOf("판매가격", idx);
				if (posPrice == -1)	break;

				// 현재 판매가격이 포함된 가장 가까운 <a ...> 시작점 찾기
				int aStart = html.lastIndexOf("<a", posPrice);
				if (aStart == -1) {
					idx = posPrice + 4;
					continue;
				}

				// 해당 <a>의 끝 </a> 찾기
				int aEnd = html.indexOf("</a>", posPrice);
				if (aEnd == -1) {
					idx = posPrice + 4;
					continue;
				}

				// 블록 추출 (상품 1개 카드라고 가정)
				String block = html.substring(aStart, Math.min(aEnd + 4, html.length()));

				// 다음 탐색 시작 위치는 해당 </a> 이후로 (중복 방지)
				idx = aEnd + 4;

				// 3) 브랜드/상품명/가격 추출
				String brand = extractTextByClass(block, "css-408eai"); // 브랜드 영역
				String name = extractTextByClass(block, "css-1mrk1dy"); // 상품명 영역
				String price = extractPriceAfterKeyword(block, "판매가격"); // 판매가격 숫자만 뽑기

				// 값 정리(HTML entity 일부 디코딩)
				brand = htmlUnescapeBasic(brand);
				name = htmlUnescapeBasic(name);

				// 상품명 없는 블록은 스킵 (광고/기타 카드일 수 있음)
				if (name.isEmpty() || price.isEmpty())	continue;

				if (brand.isEmpty()) brand = "브랜드없음";

				System.out.println("[" + brand + "] " + name + " " + price);
				printed++;
				
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}

	// className이 포함된 태그의 "바로 안쪽 텍스트" 추출
	private static String extractTextByClass(String block, String className) {
		int cPos = block.indexOf(className);
		if (cPos == -1) return "";

		int gt = block.indexOf(">", cPos);
		if (gt == -1) return "";

		int lt = block.indexOf("<", gt + 1);
		if (lt == -1) return "";

		String text = block.substring(gt + 1, lt).trim();

		// 혹시 공백/개행만 있으면 빈 값 처리
		return text.isBlank() ? "" : text;
	}

	// 태그(<...>)는 건너뛰고 텍스트만 훑음
	private static String extractPriceAfterKeyword(String block, String keyword) {
		int k = block.indexOf(keyword);
		if (k == -1) return "";

		int i = k + keyword.length();

		StringBuilder num = new StringBuilder(32);
		boolean started = false;

		while (i < block.length()) {
			char ch = block.charAt(i);

			// 태그 스킵: < ... >
			if (ch == '<') {
				int close = block.indexOf(">", i + 1);
				if (close == -1) break;
				i = close + 1;
				continue;
			}

			// 숫자/콤마 수집
			if ((ch >= '0' && ch <= '9') || ch == ',') {
				num.append(ch);
				started = true;
				i++;
				continue;
			}

			// "원" 만났고, 이미 숫자를 모았으면 종료
			if (started && ch == '원') {
				return num.toString() + "원";
			}

			i++; // 숫자 시작 전엔 그냥 계속 전진
		}

		// 혹시 "원"을 못 만나도 숫자는 모았으면 반환 (fallback)
		return num.length() > 0 ? (num.toString() + "원") : "";
	}

	// HTML Entity 디코딩
	private static String htmlUnescapeBasic(String s) {
		if (s == null || s.isEmpty())
			return "";
		return s.replace("&amp;", "&").replace("&lt;", "<").replace("&gt;", ">").replace("&quot;", "\"")
				.replace("&#39;", "'").replace("&nbsp;", " ").trim();
	}
}
