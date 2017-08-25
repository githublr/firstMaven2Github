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
	
	/**1.���߳���<corepoolsizeʱ������������ֱ�Ӵ���
	 * 2.���߳�������corepoolsizeʱ�����Խ�����������
	 * 3.���������ʧ�ܣ����Դ����µ��߳�(���߳���������maximum��ֱ�ӱ���)
	 * SynchronousQueueͬ�����У����˼���������˷ų�����֮��Ȼ
	 * ArrayBlockingQueue�н���У�����������������ʧ�ܣ�����Դ������߳�ֱ��maximum
	 * LinkedBlockingQueue�޽���У������ڼ���ʧ�ܣ�maximumʧЧ�������Դ���newfixedthreadpool����������ʹ�����ֶ��У���maximum���ø�corepoolһ����
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
//	    	����HttpGet��HttpPost���󣬽�Ҫ�����URLͨ�����췽������HttpGet��HttpPost����
	    	HttpGet httpRequst = new HttpGet(uriAPI);

//	    	new DefaultHttpClient().execute(HttpUriRequst requst);
	    	try {
	   //ʹ��DefaultHttpClient���execute��������HTTP GET���󣬲�����HttpResponse����
				HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequst);//����HttpGet��HttpUriRequst������
			    if(httpResponse.getStatusLine().getStatusCode() == 200)
			    {
			    	HttpEntity httpEntity = httpResponse.getEntity();
			    	result = EntityUtils.toString(httpEntity);//ȡ��Ӧ���ַ���
			    // һ����˵��Ҫɾ��������ַ� 
			    	result.replaceAll("\r", "");//ȥ�����ؽ���е�"\r"�ַ���������ڽ���ַ���������ʾһ��С����  
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
			    	String result = EntityUtils.toString(httpEntity);//ȡ��Ӧ���ַ���
			    	System.out.println(sdf.format(new Date()) + " " + params +" " +  result);
//			    	result.replaceAll("\r", "");//ȥ�����ؽ���е�"\r"�ַ���������ڽ���ַ���������ʾһ��С����  
			    	
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
		try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw

			/* ����TXT�ļ� */
			String pathname = path + "dictionary.txt"; // ����·�������·�������ԣ������Ǿ���·����д���ļ�ʱ��ʾ���·��
			File filename = new File(pathname); // Ҫ��ȡ����·����input��txt�ļ�
			InputStreamReader reader = new InputStreamReader(
					new FileInputStream(filename)); // ����һ������������reader
			BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������
			String line = "";
			while (true) {
				line = br.readLine(); // һ�ζ���һ������
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
		  try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw

				/* ����TXT�ļ� */
				String pathname = path + "remain.txt"; // ����·�������·�������ԣ������Ǿ���·����д���ļ�ʱ��ʾ���·��
				File filename = new File(pathname); // Ҫ��ȡ����·����input��txt�ļ�
				InputStreamReader reader = new InputStreamReader(
						new FileInputStream(filename)); // ����һ������������reader
				BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������
				String line = "";
				while (true) {
					line = br.readLine(); // һ�ζ���һ������
					
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
