package com.hkesports.matchticker.test.api;

public class MakeGuessTester extends BasicApiTester {
	
//	private static final String url = "http://emt.hkesports.com/rest/emt/api/v1/makeguess";
	private static final String url = "http://127.0.0.1:8080/enhanced-match-ticker-api-controller/rest/emt/api/v1/makeguess";
	
	public static void main(String[] args) throws Exception {
		MakeGuessTester mgTester = new MakeGuessTester();
		
//		mgTester.testUser();
		mgTester.testDevice();
	}

	public void testUser() throws Exception {
		String registrationID = "AAAA-AAAA-AAAA-AAAA-AAAA-AAAA";
		String secretKey = getSecretKey(registrationID, "1234567890");
		
		ConnUtil conn = new ConnUtil(url)	
				.data("matchID", "16")
				.data("contestantID", "4")
				.data("gameNumber", "2")
				.data("ha", "10")//String.valueOf(random.nextInt(5000))
				.data("registrationID", registrationID)
				.data("secretKey", secretKey);
		
//		mutliTest(conn, 10);
		singleTest(conn);
	}
	
	public void testDevice() throws Exception {
		String registrationID = "aaaw01-7ff1-g5gw5wq52nn52321y13s27-8ad6-4rthsr5stj5set5er521h";
		
		ConnUtil conn = new ConnUtil(url)	
				.data("matchID", "37257")
				.data("contestantID", "1")
				.data("gameNumber", "2")
				.data("ha", "900")//String.valueOf(random.nextInt(5000))
				.data("registrationID", registrationID);
		
//		mutliTest(conn, 20);
		singleTest(conn);
	}
	
	
}
