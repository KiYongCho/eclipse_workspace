/*
	Producer / Consumer 패턴 : 생산자는 생산만하고 소비자는 소비만하는 패턴
*/

package thread;

public class Product {
	
	private String product; // 제품명
	
	// 제품을 생산하는 메소드
	public synchronized void produce(String product) {
		while (this.product != null) {
			try {
				wait();  // 제품이 소비될때까지 대기
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		this.product = product;
		System.out.println("제품 생산 : " + product);
		notify(); // 제품을 소비하라고 알림
	}
	
	// 제품을 소비하는 메소드
	public synchronized String consume() {
		while (this.product == null) {
			try {
				wait(); // 생산할때까지 대기
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		String result = this.product;
		this.product = null;
		System.out.println("제품 소비 : " + result);
		notify(); // 제품을 생산하라고 알림
		return result;	
	}

}







