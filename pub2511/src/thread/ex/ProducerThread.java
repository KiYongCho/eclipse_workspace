package thread.ex;

public class ProducerThread extends Thread {

    private TVFactory tvFactory;
    
    public ProducerThread() {
	}

    public ProducerThread(TVFactory tvFactory) {
        this.tvFactory = tvFactory;
    }

    @Override
    public void run() {
        while (true) {
            try {
                tvFactory.produce((int)(Math.random() * 6) + 5); // 5 ~ 10
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                interrupt();
                break;
            }
        }
    }
}
