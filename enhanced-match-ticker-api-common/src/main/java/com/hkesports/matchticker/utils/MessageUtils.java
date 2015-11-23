package com.hkesports.matchticker.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

public class MessageUtils {
	
	public static String getLinebreak(){
		return System.getProperty("line.separator");
	}
	
	public static String joinListToString(List<?> list) {
		StringBuilder message = new StringBuilder();
		for(Object value : list) {
			joinToString(message, value);
		}
		return message.toString();
	}
	
	public static void joinToString(StringBuilder message, Object value) {
		if(message.length() > 0)
			message.append(",");
		message.append(value);
	}
	
	public static String joinMapToString(Map<Long, ?> map){
		StringBuilder message = new StringBuilder();
		for(Long key : map.keySet()){
			if(message.length() > 0)
				message.append(",");
			message.append(" {").append(key).append(": ").append(map.get(key)).append("}");
		}
		return "{" + message.toString() + "}";
	}
	
	public static String getMailTemplate(String fileName) {
		ClassPathResource res = new ClassPathResource("mail" + File.separator + fileName);
		InputStream in = null;
		DataInputStream dis = null;
		BufferedReader br = null;
		StringBuilder mailContent = new StringBuilder();
		String strLine = "";
		try {
			in = res.getInputStream();
			dis = new DataInputStream(in);
			br = new BufferedReader(new InputStreamReader(dis, "UTF-8"));
			while ((strLine = br.readLine()) != null) {
				mailContent.append(strLine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(in);
			IOUtils.closeQuietly(dis);
			IOUtils.closeQuietly(br);
		}
		return mailContent.toString();
	}
}
