package com.my.vk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.my.ProxyConfig;

public class VkExecutor {
	
	private ProxyConfig proxy = new ProxyConfig();
	
	public VkExecutor() {
		
	}
	
	public VkExecutor(ProxyConfig proxy) {
		this.proxy = proxy;
	}
	
	public ProxyConfig getProxy() {
		return proxy;
	}

	public void setProxy(ProxyConfig proxy) {
		this.proxy = proxy;
	}

	public String executeVkMethod(String method, String fields, String version) throws IOException {
		String entity;
		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpHost target = new HttpHost(VkConstants.vkURL, 80, "http");

            HttpGet request = new HttpGet(method + "?user_ids=1,2,3,4,5,6,7&fields=" + fields + "&v=" + version);
            proxy.setProxy(request);

            CloseableHttpResponse response = httpclient.execute(target, request);
            try {
                System.out.println(response.getStatusLine());
                entity = convertHttpEntityToString(response.getEntity());
                System.out.println(entity);
                EntityUtils.consume(response.getEntity());
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
		return entity;
	}
	
	public static String convertHttpEntityToString(HttpEntity ent) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(ent.getContent(), "utf-8"));
			char[] buffer = new char[1024];
			int count;
			while ((count = br.read(buffer)) != -1) {
				sb.append(buffer, 0, count);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
