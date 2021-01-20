package com.n22.springboot.utils;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;


/**
 * http客户端调用工具类
 */
public class HttpClientCoreUtil {


	/**
	 * http.get请求
	 * 
	 * @method: httpsGet
	 * @Description: http.get请求
	 * @param url     请求地址
	 * @param timeOut 超时时间
	 * @return
	 * @author : sunxh30
	 * @date 2016年7月8日 上午10:35:03
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String httpsGet(String url, int timeOut) {
		long start = System.currentTimeMillis(); // 获取开始时间
		System.out.println("url : " + url);
		HttpClient httpclient = getHttpsClient();
		try {
			HttpParams params = httpclient.getParams();
			params.setParameter(CoreConnectionPNames.SO_TIMEOUT, timeOut);
			HttpGet httpget = new HttpGet(url);
			ResponseHandler responseHandler = new BasicResponseHandler();
			Object responseBody = httpclient.execute(httpget, responseHandler);
			System.out.println("responseBody : " + responseBody);
			if (responseBody != null) {
				return responseBody.toString();
			}
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				httpclient.getConnectionManager().shutdown();
				long end = System.currentTimeMillis(); // 获取开始时间
				System.out.println("HTTP___请求时间： " + (end - start) + "ms");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	public static HttpClient getHttpsClient() {
		HttpClient httpclient = new DefaultHttpClient();
		SSLContext ctx;
		try {
			ctx = SSLContext.getInstance("SSL");
			X509TrustManager tm = new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
				}

				public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
				}

				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			};
			ctx.init(null, new TrustManager[] { tm }, null);
			SSLSocketFactory ssf = new SSLSocketFactory(ctx);
			ClientConnectionManager ccm = httpclient.getConnectionManager();
			SchemeRegistry sr = ccm.getSchemeRegistry();
			sr.register(new Scheme("https", 443, ssf));
		} catch (Exception e) {
			System.out.println("[error] HttpClientUtils.getHttpsClient()");
			e.printStackTrace();
		}
		return httpclient;
	}

}
