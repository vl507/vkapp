package com.my;

import org.apache.http.client.methods.HttpGet;

public class ProxyConfig {

	private ProxyInstance proxy;

	public ProxyConfig() {

	}

	public ProxyConfig(ProxyInstance proxy) {
		this.proxy = proxy;
	}

	public ProxyInstance getProxy() {
		return proxy;
	}

	public void setProxy(ProxyInstance proxy) {
		this.proxy = proxy;
	}

	public HttpGet setProxy(HttpGet request) {
		if (proxy != null) {
			request.setConfig(proxy.getRequestConfig());
		}
		return request;
	}

}
