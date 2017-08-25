package offer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *  ��ʱ��ʹ��Future�о��ܳ�ª����Ϊ����Ҫ������Future�Ƿ�����ɣ���ʹ�ûص���ֱ���յ�����֪ͨ��
 * @author wilson
 *
 */
public class FutureExample {
	public static void main(String[] args) throws Exception {  
		//�����̳߳�
		        ExecutorService executor = Executors.newCachedThreadPool();  
		        //�����߳�
			        Runnable task1 = new Runnable() {  
			        	
			            @Override  
			            public void run() {  
			                //do something  
			                System.out.println("��һ��runnable�߳�.....");  
			            }  
			        }; 
			        //�����߳�
			        Callable<Integer> task2 = new Callable<Integer>() {  
			            @Override  
			            public Integer call() throws Exception {  
			                //do something  
			            	System.out.println("�ڶ���Callable�̡߳���");
			                return new Integer(100);  
			            }  
			        };  
			        //�ύ��һ���߳�
			        Future<?> f1 = executor.submit(task1);  
			        //�ύ�ڶ����߳�
			        Future<Integer> f2 = executor.submit(task2);  
			        //��ӡ��1���߳��Ƿ����
			        System.out.println("��1���߳��Ƿ����? " + f1.isDone()); 
			      //��ӡ��2���߳��Ƿ����
			        System.out.println("��2���߳��Ƿ����? " + f2.isDone());  
			        //�ȴ���һ���߳̽���
			        while(f1.isDone()){  
			            System.out.println("��һ���߳̽���");  
			            break;  
			        }  
			        //�ȴ��ڶ����߳̽���
			        while(f2.isDone()){  
			            System.out.println("�ڶ����߳̽��������ؽ��: " + f2.get());  
			            break;  
			        }  
			    } 

}
