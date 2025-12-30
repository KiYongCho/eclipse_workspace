package basic.ex;

public class ExMethod2 {
	
	public static void main(String[] args) {
		
		printSum(getSum(1.1, 2.34, 3.12));
		
	} // main
	
	static double getSum(double d1, double d2, double d3) {
		return d1 + d2 + d3;
	}
	
	static void printSum(double sum) {
		System.out.println(sum);
	}

}
