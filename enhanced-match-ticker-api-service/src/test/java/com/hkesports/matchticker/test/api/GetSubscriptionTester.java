package com.hkesports.matchticker.test.api;

public class GetSubscriptionTester extends BasicApiTester {
	
//	private static final String url = "http://127.0.0.1:8080/enhanced-match-ticker-api-controller/rest/emt/api/v1/getcontestantsubscription";
	
	private static final String url = "http://127.0.0.1:8080/enhanced-match-ticker-api-controller/rest/emt/api/v1/getmatchsubscription";
	
	public static void main(String[] args) throws Exception {
		GetSubscriptionTester tester = new GetSubscriptionTester();
		
//		tester.testUser();
		tester.testDevice();
	}

	public void testUser() throws Exception {
		String registrationID = "AAAA-AAAA-AAAA-AAAA-AAAA-AAAA";
		String secretKey = getSecretKey(registrationID, "1234567890");
		
		ConnUtil conn = new ConnUtil(url)	
				.data("team", "true")
				.data("registrationID", registrationID)
				.data("secretKey", secretKey);
		
		singleTest(conn);
//		mutliTest(conn, 20);
	}
	
	public void testDevice() throws Exception {
		String registrationID = "aaaw01-7ff1-g5gw5wq52nn52321y13s27-8ad6-4rthsr5stj5set5er521h";
		ConnUtil conn = new ConnUtil(url)	
				.data("team", "true")
				.data("registrationID", registrationID);
		
		singleTest(conn);
//		mutliTest(conn, 20);
	}
	
}
