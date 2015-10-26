package com.hkesports.matchticker.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author manboyu
 *
 */
public class ResponseVo<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private T Response;
	
	public ResponseVo(){
		
	}
	
	public ResponseVo(T Response) {
		this.Response = Response;
	}

	@JsonProperty("Response")
	public T getResponse() {
		return Response;
	}

	public void setResponse(T response) {
		Response = response;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
