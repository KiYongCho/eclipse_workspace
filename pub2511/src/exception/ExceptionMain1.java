package exception;

public class ExceptionMain1 {
	
	public static void main(String[] args) {
		
		int[] iarr = {1, 2, 3, 4, 5}; // length 5, index 0~4 
		
		// 예외 발생 가능한 코드 블럭
		try {
			
			// int i1 = iarr[5]; // ArrayIndexOutOfBoundsException
			
			// int i2 = Integer.parseInt("백원"); // NumberFormatException
			
			// int i3 = 10 / 0; // ArithmeticException (Divide by zero)
			
			Object obj = null;
			System.out.println(obj.hashCode()); // NullPointerException
			
		}
		// try 구문안에서 발생가능한 모든 예외는 각각 catch에서 처리하는 것이 원칙!
		// 하지만 예외의 종류가 너무 다양하면 코드가 너무 길어지므로
		// 상위예외로 묶어서 처리 가능 => 단점은 코드를 보고서는 정확한 예외 파악이 어려움
		
		// catch를 2개 이상 사용할때는 코드 상위의 예외가 더 하위 예외여야 함
		// 예를 들어
		// catch (ArithmeticException ae) { ... }
		// catch (RuntionException re) { ... }
		// catch (Exception e) { ... }
		// catch (Throwable th) { ... }		
		
//		catch (ArrayIndexOutOfBoundsException aioobe) {
//			aioobe.printStackTrace();
//		}
//		catch (NumberFormatException nfe) {
//			nfe.printStackTrace();
//		}
//		catch (ArithmeticException ae) {
//			ae.printStackTrace();
//		}
		catch (RuntimeException re) {
			re.printStackTrace();
		}
		// 예외 발생 여부와 상관없이 수행할 코드 블럭
		finally {
			System.out.println("예외 발생 여부와 상관없이 수행할 코드!");
		}
		
		System.out.println("순차적으로 수행되어야 할 코드!");
		
	}

}














































