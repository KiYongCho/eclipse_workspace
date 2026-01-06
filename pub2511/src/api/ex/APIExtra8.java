package api.ex;

public class APIExtra8 {
	
	public static void main(String[] args) {
		
		String line = Util.getLineText(1)[0];
		
		char[] chArr = line.toCharArray();
		
		int[] countArr = new int[4];
		
		for (char ch : chArr) {
			byte b = (byte)ch;
			if (b>64 && b<91) {
				countArr[0]++;
			} else if (b>96 && b<123) {
				countArr[1]++;
			} else if (b>47 && b<58) {
				countArr[2]++;
			} else {
				countArr[3]++;
			} 
		}
		
		System.out.printf("대문자:%d, 소문자:%d, 숫자:%d, 기호:%d",
			countArr[0], countArr[1], countArr[2], countArr[3]);
		
	}

}












