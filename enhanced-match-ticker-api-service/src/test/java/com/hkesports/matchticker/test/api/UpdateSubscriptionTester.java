package com.hkesports.matchticker.test.api;

public class UpdateSubscriptionTester extends BasicApiTester {
//	private static final String url = "http://127.0.0.1:8080/enhanced-match-ticker-api-controller/rest/emt/api/v1/updatecontestantsubscription";

	private static final String url2 = "http://emt.hkesports.com/rest/emt/api/v1/updatecontestantsubscription";
	
	private static final String url = "http://emt.hkesports.com/rest/emt/api/v1/updatematchsubscription";
	
	public static void main(String[] args) throws Exception {
		UpdateSubscriptionTester mgTester = new UpdateSubscriptionTester();
		
		mgTester.testUser();
		mgTester.testDevice();
	}

	public void testUser() throws Exception {
		String registrationID = "AAAA-AAAA-AAAA-AAAA-AAAA-AAAA";
		String secretKey = getSecretKey(registrationID, "1234567890");
		
		ConnUtil conn = new ConnUtil(url)	
				.data("team", "true")
				.data("matchID", "2")
				.data("subscribe", "true")
				.data("registrationID", registrationID)
				.data("secretKey", secretKey);
//		mutliTest(conn, 20);
		singleTest(conn);
	}
	
	public void testDevice() throws Exception {
		String registrationID = "aaaw01-7ff1-g5gw5wq52nn52321y13s27-8ad6-4rthsr5stj5set5er521h";
		
		ConnUtil conn = new ConnUtil(url)	
				.data("team", "true")
				.data("matchID", "2")
				.data("subscribe", "true")
				.data("registrationID", registrationID);
		
//		mutliTest(conn, 20);
		singleTest(conn);
	}
	
}
