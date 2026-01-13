package thread.ex;

public class TVFactory {

    private int currAmt; // 현재 수량
    private int maxAmt; // 최대 수량
    
    public TVFactory() {
	}

    public TVFactory(int maxAmt) {
    	this.currAmt = 100;
        this.maxAmt = maxAmt;
    }

    // 생산 : 창고가 꽉 차면 기다린다.
    public synchronized void produce(int amt) {
        while (currAmt+amt > maxAmt) {
        	try {
        		wait();
        	} catch (InterruptedException ie) {
        		ie.printStackTrace();
        	}
        }
        currAmt += amt;
        System.out.println(amt + "개의 TV 생산!");
        System.out.println("생산 후 총 수량 : " + currAmt);
        notifyAll();
    }

    // 판매 : 재고가 부족하면 기다린다.
    public synchronized void consume(int amt) throws InterruptedException {
        while (currAmt < amt) {
        	try {
        		wait();
        	} catch (InterruptedException ie) {
        		ie.printStackTrace();
        	}     	
        }
        currAmt -= amt;
        System.out.println(amt + "개의 TV 판매!");
        System.out.println("판매 후 총 수량 : " + currAmt);
        notifyAll();
    }
    
}
