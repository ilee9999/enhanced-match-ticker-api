package com.hkesports.matchticker.test.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;

public class BasicApiTester {
	
//	public static final String getencoder = "http://emt.hkesports.com:9060/rest/auth/v1/test/getEncoder";
	public static final String getencoder = "http://127.0.0.1:8080/enhanced-match-ticker-auth/rest/auth/v1/test/getEncoder";
	protected final Random random = new Random();
	
	public String getSecretKey(String registrationID, String secretKey) throws IOException {
		String key = getConn(getencoder, Method.GET)
		.data("registrationID", registrationID)
		.data("encoderString", secretKey).execute().body();
		return key;
	} 
	
	public Connection getConn(String url) {
		return getConn(url, Method.POST);
	}
	
	public Connection getConn(String url, Method method) {
		return Jsoup.connect(url).ignoreContentType(true).userAgent("chrome").timeout(500000).method(method);
	}
	
	protected String singleTest(ConnUtil conn) throws Exception {
		String result = getConn(conn.getUrl()).data(conn.getMap()).execute().body();
		System.out.println(result);
		return result;
	}
	
	protected void mutliTest(ConnUtil conn, int concurrent_size) {
		ExecutorService executor = Executors.newFixedThreadPool(concurrent_size);
		for (int i = 0; i < concurrent_size; i++) {
			executor.execute(new Work(conn));
		}
		executor.shutdown();
	}
	
	public class ConnUtil {
		private String url;
		private Map<String, String> map;
		public ConnUtil(){}
		public ConnUtil(String url) {
			this.url = url;
			map = new HashMap<>();
		}
		
		public ConnUtil data(String key, String value) {
			map.put(key, value);
			return this;
		}
		public String getUrl() {
			return url;
		}
		public Map<String, String> getMap() {
			return map;
		}
	}
	
	public class Work implements Runnable {

		private ConnUtil conn;
		public Work(ConnUtil conn) {
			this.conn = conn;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					String response = getConn(conn.url).data(conn.map).execute().body();
					if (response != null && !response.contains("{\"statusCode\":0}")) {
						System.out.println(response);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
