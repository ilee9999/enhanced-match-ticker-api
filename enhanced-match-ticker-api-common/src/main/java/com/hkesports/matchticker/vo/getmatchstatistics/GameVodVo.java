package com.hkesports.matchticker.vo.getmatchstatistics;

import java.io.Serializable;

public class GameVodVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String type; //LiveStreams.type
	private String URL; //LiveStreams.url
	private String embedCode; //LiveStreams.embedCode

	public GameVodVo() {}
	
	public GameVodVo(String type, String uRL, String embedCode) {
		super();
		this.type = type;
		this.URL = uRL;
		this.embedCode = embedCode;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getEmbedCode() {
		return embedCode;
	}

	public void setEmbedCode(String embedCode) {
		this.embedCode = embedCode;
	}

}
