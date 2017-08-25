package offer.Threadlr;

/**
 * Created by zack.lr on 2017/7/13.
 */
//class SyncThread implements Runnable {
class SyncThread {
    private static int count;

    public SyncThread() {
        count = 0;
    }

    public  void runlr() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCount() {
        return count;
    }
}
