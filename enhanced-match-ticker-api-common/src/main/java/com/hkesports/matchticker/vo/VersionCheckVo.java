package com.hkesports.matchticker.vo;

public class VersionCheckVo extends BasicVo {
	private static final long serialVersionUID = 1L;
	
	private String versionID;
	private String URL;
	private String Description;
	
	public String getVersionID() {
		return versionID;
	}
	public void setVersionID(String versionID) {
		this.versionID = versionID;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
}
