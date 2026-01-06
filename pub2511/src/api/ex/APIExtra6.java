package api.ex;

public class APIExtra6 {
	
	public static void main(String[] args) {
		
		String line = Util.getLineText(1)[0];
		
		char[] chArr = line.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		
		for (char ch : chArr) {
			if (ch != ' ') {
				sb.append(ch);
			}
		}
		
		System.out.println(sb);
		
	}

}










