package thread.ex;

public class ConsumerThread extends Thread {

    private TVFactory tvFactory;
    
    public ConsumerThread() {
	}

    public ConsumerThread(TVFactory tvFactory) {
        this.tvFactory = tvFactory;
    }

    @Override
    public void run() {
        while (true) {
            try {
                tvFactory.consume((int)(Math.random() * 6) + 3); // 3 ~ 8
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                interrupt();
                break;
            }
        }
    }
}
