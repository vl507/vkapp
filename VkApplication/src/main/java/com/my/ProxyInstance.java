package com.my;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;

public class ProxyInstance {
	
	public final String PROXY_HOST = "192.168.134.52";
	public final int PROXY_PORT = 81;
	

	public RequestConfig getRequestConfig() {
		HttpHost proxy = new HttpHost(PROXY_HOST, PROXY_PORT, "http");
		return RequestConfig.custom().setProxy(proxy).build();
	}

}
