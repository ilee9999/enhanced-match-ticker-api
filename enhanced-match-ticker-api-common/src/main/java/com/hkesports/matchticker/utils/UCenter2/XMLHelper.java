package com.hkesports.matchticker.utils.UCenter2;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.LinkedList;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import com.sun.org.apache.xerces.internal.xni.parser.XMLInputSource;

/**
 * ================================================
 * Discuz! Ucenter API for JAVA
 * ================================================
 * XML工具类���处���UC Client��收��������������
 * UC Client会�?��UC Server返���XML结�
 * 该类将XML中�����据������个List��顺序读��即�����
 * 
 * �����信息：http://code.google.com/p/discuz-ucenter-api-for-java/
 * 作�：����(no_ten@163.com) 
 * �����间��009-2-20
 */
public class XMLHelper {

	public static LinkedList<String> uc_unserialize(String input){
		
		LinkedList<String> result = new LinkedList<String>();
		
		DOMParser parser = new DOMParser();
		try {			
			parser.parse(new InputSource(new StringReader(input)));
			Document doc = parser.getDocument();
			NodeList nl = doc.getChildNodes().item(0).getChildNodes();
			int length = nl.getLength();
			for(int i=0;i<length;i++){
				if(nl.item(i).getNodeType()==Document.ELEMENT_NODE)
					result.add(nl.item(i).getFirstChild().getNodeValue());
			}
		} catch (SAXException e) {
			
		} catch (IOException e) {
			
		}
		return result;
	}
}
