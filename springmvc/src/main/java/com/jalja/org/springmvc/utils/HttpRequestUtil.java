package com.jalja.org.springmvc.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpRequestUtil {
	private static PoolingHttpClientConnectionManager connectionManager = null;  
    private static HttpClientBuilder httpBulder = null;  
    private static RequestConfig requestConfig = null;  
    private static int MAXCONNECTION = 10;  
    private static int DEFAULTMAXCONNECTION = 5;  
    private static String IP = "cnivi.com.cn";  
    private static int PORT = 80;
    static {  
    	init();
    }
    public static void init() {
    	 //设置http的状态参数  
        requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000)  
                .setConnectionRequestTimeout(5000).build();  
        HttpHost target = new HttpHost(IP, PORT);  
        connectionManager = new PoolingHttpClientConnectionManager();  
        connectionManager.setMaxTotal(MAXCONNECTION);  
        connectionManager.setDefaultMaxPerRoute(DEFAULTMAXCONNECTION);  
        connectionManager.setMaxPerRoute(new HttpRoute(target), 20);  
        httpBulder = HttpClients.custom();  
        httpBulder.setConnectionManager(connectionManager);  
    }
    public static CloseableHttpClient getConnection() {  
        CloseableHttpClient httpClient = httpBulder.build();  
        httpClient = httpBulder.build();  
        return httpClient;  
    }  
    public static HttpUriRequest getRequestMethod(Map<String, String> map, String url, String method) {  
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if(map!=null) {
        	Set<Map.Entry<String, String>> entrySet = map.entrySet();  
        	for (Map.Entry<String, String> e : entrySet) {  
        		String name = e.getKey();  
        		String value = e.getValue();  
        		NameValuePair pair = new BasicNameValuePair(name, value);  
        		params.add(pair);  
        	}  
        }
        HttpUriRequest reqMethod = null;
        if(method==null || method.equals("") ||  "get".equals(method.toLowerCase()) ) {
        	 reqMethod = RequestBuilder.get().setUri(url)  
                     .addParameters(params.toArray(new BasicNameValuePair[params.size()]))  
                     .setConfig(requestConfig).build();  
        }else if("post".equals(method.toLowerCase())) {
        	 reqMethod = RequestBuilder.post().setUri(url).setCharset(Consts.UTF_8)  
                     .addParameters(params.toArray(new BasicNameValuePair[params.size()]))  
                     .setConfig(requestConfig).build();  
        } 
        return reqMethod;  
    }
    /**
     * 获取请求数据
     * @param map 请求参数 
     * @param url 请求地址 
     * @param method 请求方式 get post 默认get
     * @return 返回字符串
     */
    public static String getResult(Map<String, String> map, String url, String method){
		HttpClient client = getConnection();  
	    HttpUriRequest post = getRequestMethod(map, url, method);  
	    String strResult="";
	    try {
	    	HttpResponse response = client.execute(post);
	    	if(response.getStatusLine().getStatusCode()==405) {
		 			throw new RuntimeException("请求方式错误");
		 	}
	 		if(response.getStatusLine().getStatusCode()!=200) {
	 			throw new RuntimeException("服务调用异常");
	 		}
	 		HttpEntity httpEntity= response.getEntity();  
	 		strResult= EntityUtils.toString(httpEntity,Consts.UTF_8);  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strResult;
    }
    public static String getIpAddress(HttpServletRequest request) {  
        String ip = request.getHeader("x-forwarded-for");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    }  
    public static void main(String[] args) {
    	String apiUrl = String.format("https://www.sojson.com/open/api/weather/json.shtml?city=%s","北京");
    	System.out.println(getResult(null,apiUrl,null));
	}
}
