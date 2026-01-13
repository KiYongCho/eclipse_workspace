package thread;

public class ThreadTest5 {
	
	public static void main(String[] args) {
		
		Product product = new Product();
		
		// 생산자 쓰레드 : 제품을 3개 생산
		Thread producer = new Thread(() -> {
			for (int i=1; i<=3; i++) {
				product.produce("제품" + i);
			}
		});
		
		// 소비자 쓰레드 : 제품을 3개 소비
		Thread consumer = new Thread(() -> {
			for (int i=1; i<=3; i++) {
				product.consume();
			}
		});
		
		producer.start();
		consumer.start();
		
	}

}






