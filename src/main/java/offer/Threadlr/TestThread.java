package offer.Threadlr;

/**
 * Created by zack.lr on 2017/7/12.
 */


public class TestThread
{
    public static void main(String[] args)
    {
        int i = 1 ;
        for (i=1;i<100 ;i++ )
        {
            new test(i).start();
        }
    }

}
class test extends Thread
{
    private int iNum = 0;
    boolean stoped = false;
    public test(int num)
    {
        this.iNum = num ;
    }
    public void run()
    {
        synchronized (this) {
            while (!stoped)
            {
                try
                {
                    this.sleep(30);
                }catch(Exception e) {
//
                }
                System.out.println("正在运行第" + iNum + "个线程!");
            }
        }
    }
    public void stoped()
    {
        this.stoped = true;
    }
}
