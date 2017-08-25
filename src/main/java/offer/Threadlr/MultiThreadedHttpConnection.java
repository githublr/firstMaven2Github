package offer.Threadlr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

@SuppressWarnings("deprecation")
public class MultiThreadedHttpConnection {
	private static CloseableHttpClient httpClient;
	private static final String contextType = "text/xml;charset=UTF-8";
//	private static ExecutorService es = Executors.newFixedThreadPool(10000);
//	private static final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
	private static final BlockingQueue<Runnable> queue =  new LinkedBlockingQueue<Runnable>();
	private static ExecutorService es = new ThreadPoolExecutor(10000, 10000, 1,TimeUnit.NANOSECONDS, queue);
	
	/**1.当线程数<corepoolsize时，有新任务则直接创建
	 * 2.当线程数超过corepoolsize时，尝试将任务放入队列
	 * 3.若放入队列失败，则尝试创建新的线程(若线程数，超过maximum则直接报错)
	 * SynchronousQueue同步队列，有人加入必须有人放出，反之亦然
	 * ArrayBlockingQueue有界队列，限制容量，当加入失败，则可以创建新线程直到maximum
	 * LinkedBlockingQueue无界队列，不存在加入失败，maximum失效。所以自带的newfixedthreadpool方法，由于使用这种队列，将maximum设置跟corepool一样大。
	 */
//	private static final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
	
//	private static ThreadPoolExecutor ee =  new ThreadPoolExecutor(20, 20, 0L, TimeUnit.MILLISECONDS, queue);
	private static MultiThreadedHttpConnection mthc = new MultiThreadedHttpConnection();
	private static String url = "http://swoogle.umbc.edu/SimService/GetSimilarity?operation=api&corpus=webbase&type=relation";
	private static int maxTotal = 300;//300
	private static int maxPerRout = 200;
	private static int connecttimeOut = 10000;
	private static int readTimeOut = 5000;
    public static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public static String path = "d:\\";
//    public static String path = "./";
    public static String fileName= path + "similarity.txt";
	
	public static FileWriter writer = null;
	public static FileWriter errwriter = null;
	
	static {
//		ThreadSafeClientConnManager cm = new ThreadSafeClientConnManager();
//		cm.setMaxTotal(maxTotal);
//		cm.setDefaultMaxPerRoute(maxPerRout);

//		HttpParams params = new BasicHttpParams();
//		HttpConnectionParams.setConnectionTimeout(params, connecttimeOut);
//		HttpConnectionParams.setSoTimeout(params, readTimeOut);

//		httpClient = new DefaultHttpClient(cm, params);
		
		
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(maxTotal);
		cm.setDefaultMaxPerRoute(maxPerRout);
		
	   
	    httpClient = HttpClients.custom().setConnectionManager(cm).build();
	   
	    
	    /**
	     * 
	     * test httpclinet close
	     */
	}
	
	

	private MultiThreadedHttpConnection() {
		
	}

	
	 
    
    
	public static MultiThreadedHttpConnection getInstance() {
		return mthc;
	}

	public void httpAsyncSendByMap(final Map<String, String> map) {
		es.execute(new postThread(mthc, map));
	}

	
	 public String doGet(String params)
	    {
	    	String uriAPI = url + params;
	    	String result= "";
//	    	HttpGet httpRequst = new HttpGet(URI uri);
//	    	HttpGet httpRequst = new HttpGet(String uri);
//	    	创建HttpGet或HttpPost对象，将要请求的URL通过构造方法传入HttpGet或HttpPost对象。
	    	HttpGet httpRequst = new HttpGet(uriAPI);

//	    	new DefaultHttpClient().execute(HttpUriRequst requst);
	    	try {
	   //使用DefaultHttpClient类的execute方法发送HTTP GET请求，并返回HttpResponse对象。
				HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequst);//其中HttpGet是HttpUriRequst的子类
			    if(httpResponse.getStatusLine().getStatusCode() == 200)
			    {
			    	HttpEntity httpEntity = httpResponse.getEntity();
			    	result = EntityUtils.toString(httpEntity);//取出应答字符串
			    // 一般来说都要删除多余的字符 
			    	result.replaceAll("\r", "");//去掉返回结果中的"\r"字符，否则会在结果字符串后面显示一个小方格  
			    	System.out.println(result);
			    	
			    
			    	
			    	
			    }
	                   else 
	                        httpRequst.abort();
	           } catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = e.getMessage().toString();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				result = e.getMessage().toString();
			}
			return result;
	    }
	 
	private int sendDataByPost(Map<String, String> map) {
		Integer statusCode = -1;
		
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		String params = "";
		for (Map.Entry<String, String> m : map.entrySet()) {
			params = params + "&" + m.getKey() + "=" + m.getValue();
//			nvps.add((NameValuePair) new BasicNameValuePair(m.getKey(), m.getValue()));
		}
		
		

//		StringEntity entity;
		
		
		for(int cct = 0; cct < 20; ++ cct)
		{
			HttpPost post = new HttpPost(url + params);
			try {
//				entity = new UrlEncodedFormEntity(nvps, HTTP.UTF_8);
//				post.setEntity(entity);
				post.setHeader("Content-Type", contextType);
				HttpResponse response = httpClient.execute(post);
				statusCode = response.getStatusLine().getStatusCode();
//				System.out.println(response.getProtocolVersion());
//				System.out.println(statusCode);
				if (statusCode != 200) {
//					System.out.println("error quest");
				}else{
					HttpEntity httpEntity = response.getEntity();
			    	String result = EntityUtils.toString(httpEntity);//取出应答字符串
			    	System.out.println(sdf.format(new Date()) + " " + params +" " +  result);
//			    	result.replaceAll("\r", "");//去掉返回结果中的"\r"字符，否则会在结果字符串后面显示一个小方格  
			    	
			    	try {
						writer.write(sdf.format(new Date()) + " "  + params + " " +  Float.parseFloat(result) + "\n");
						writer.flush();
					
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    	
			    	return statusCode;
				}
			}
			catch(Exception e){
				
			}
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			} catch (ClientProtocolException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} finally {
//				post.abort();
//			}
		}
		try {
			errwriter.write(sdf.format(new Date()) + " "  + params + " "  + "\n");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return statusCode;
	}

	class postThread implements Runnable {
		private MultiThreadedHttpConnection m = null;
		private Map<String, String> map = null;

		public postThread(MultiThreadedHttpConnection m, Map<String, String> map) {
			this.m = m;
			this.map = map;
		}

		@Override
		public void run() {
			m.sendDataByPost(map);
//			System.out.println("ended");
		}
	}

	public static void main(String[] args) {
		
		
		ThreadPoolExecutor tmp = (ThreadPoolExecutor)es;
		tmp.allowCoreThreadTimeOut(true);
		
		
		List<String> dictionary = new ArrayList<String>();
		try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

			/* 读入TXT文件 */
			String pathname = path + "dictionary.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
			File filename = new File(pathname); // 要读取以上路径的input。txt文件
			InputStreamReader reader = new InputStreamReader(
					new FileInputStream(filename)); // 建立一个输入流对象reader
			BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
			String line = "";
			while (true) {
				line = br.readLine(); // 一次读入一行数据
				if(line == null){
					break;
				}
				dictionary.add(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
			
		int length = dictionary.size();
		
		int cct = 0;
		
		  try {
			  	
				 writer=new FileWriter(fileName,true);
				 errwriter = new FileWriter(path  + "error.txt", true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		  
		  List<Integer> ind1 = new ArrayList<Integer>(), ind2 = new ArrayList<Integer>();
		  try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

				/* 读入TXT文件 */
				String pathname = path + "remain.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
				File filename = new File(pathname); // 要读取以上路径的input。txt文件
				InputStreamReader reader = new InputStreamReader(
						new FileInputStream(filename)); // 建立一个输入流对象reader
				BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
				String line = "";
				while (true) {
					line = br.readLine(); // 一次读入一行数据
					
					if(line == null){
						break;
					}
					System.out.println(line);
					String[] tmp1 = line.split(" ");
					System.out.println(tmp1.length);
					ind1.add(Integer.parseInt(tmp1[0]));
					ind2.add(Integer.parseInt(tmp1[1]));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		  
		  
		  
		for(int i = 1500; i != 1501; ++ i){
////			for(int i = 1827; i != 3000; ++ i){
////		  for(int i = 3760; i != 3000; -- i){
			for(int j = 0; j != i; ++ j){
//			for(int index = 0; index != ind1.size(); ++ index){
//				for(int i = 1827; i != 3000; ++ i){
//			  for(int i = 3760; i != 3000; -- i){
				
		
				Map<String, String> map = new HashMap<String, String>();
				map.put("phrase1", dictionary.get(i));
				map.put("phrase2", dictionary.get(j));
				map.put("ind1", i+ "");
				map.put("ind2", j+"");
				System.out.println(++cct);
				if(queue.size() > 100000){
					
					Thread b = new Thread(new Runnable() {  
					    @Override  
					    public void run() {  
					       while(queue.size() > 60000);            
					    };  
					});  

				        b.start();
				 
				        synchronized (b) {
				            try {
				                System.out.println("Waiting for b to complete...");
				                b.wait();
				            } catch (Exception e) {
				                e.printStackTrace();
				            }
				        }
				        
				}
				MultiThreadedHttpConnection.getInstance().httpAsyncSendByMap(map);
				
		}
		
		
		
//		for(int i = 142; i != length - 1; ++ i){
//			
////			  THRESHOLD = 1;

//			  
//	       
//		}
//		System.exit(0);;
		}
	}
}
