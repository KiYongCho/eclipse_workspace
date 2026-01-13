package thread.ex;

public class ExThread4 {

    public static void main(String[] args) {
    	
    	System.out.println("=== 초기 수량 : 100 개 ===");

        TVFactory tvFactory = new TVFactory(200); // 최대 수량 200

        new ProducerThread(tvFactory).start();
        new ConsumerThread(tvFactory).start();
        
    }
    
}
