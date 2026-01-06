package api.ex;

public class APIExtra7 {
	
	public static void main(String[] args) {
		
		String line = Util.getLineText(1)[0];
		
		char[] chArr = line.toCharArray();
		
		StringBuilder  sb = new StringBuilder();
		
		for (char ch : chArr) {
			byte b = (byte)ch; 
			if ((b>64&&b<91) || (b>96&&b<123)) {
				if (b < 91) {
					sb.append((char)(ch+32));
				} else {
					sb.append((char)(ch-32));
				}
			}
		}
		
		System.out.println(sb);
		
	}

}








