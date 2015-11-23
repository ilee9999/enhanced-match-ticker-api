package com.hkesports.matchticker.test.api;

public class PersonalRecordTester extends BasicApiTester {
	
	private static final String url = "http://127.0.0.1:8080/enhanced-match-ticker-api-controller/rest/emt/api/v1/getpersonalrecord";
	
	public static void main(String[] args) throws Exception {
		PersonalRecordTester mgTester = new PersonalRecordTester();
		
//		mgTester.testUser();
		mgTester.testDevice();
	}

	public void testUser() throws Exception {
		String registrationID = "AAAA-AAAA-AAAA-AAAA-AAAA-AAAA";
		String secretKey = getSecretKey(registrationID, "1234567890");
		ConnUtil conn = new ConnUtil(url)	
				.data("Year", "")
				.data("registrationID", registrationID)
				.data("secretKey", secretKey);
//		mutliTest(conn, 20);
		singleTest(conn);
	}
	
	public void testDevice() throws Exception {
		String registrationID = "aaaw01-7ff1-g5gw5wq52nn52321y13s27-8ad6-4rthsr5stj5set5er521h";
		ConnUtil conn = new ConnUtil(url)	
				.data("Year", "2015")
				.data("Month", "5")
				.data("registrationID", registrationID);
//		mutliTest(conn, 20);
		singleTest(conn);
	}
	
	
}
