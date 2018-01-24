/**
 * 
 */
package com.cisco.la.common;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.cisco.la.Application;

/**
 * @author P9030576
 *
 */
@Service
public class HttpService {
	private String boltToken = "Y2lzY29zcGFyazovL3VzL0FQUExJQ0FUSU9OL2RjMGIyMmUzLTQwYjUtNGE5YS1hNWE1LTE3NDZhZDU1MzEzMA";
	public boolean checkSparkPeople(String email) throws Exception{
		String urlGetPeople = "https://api.ciscospark.com/v1/people";
		try {
			URL url = new URL(urlGetPeople);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);

			httpUrlConn.setRequestProperty("content-type", "application/json; charset=utf-8");
			httpUrlConn.setRequestProperty("authorization", "Bearer " + boltToken); 

			httpUrlConn.setRequestMethod("GET");

			httpUrlConn.connect();

			DataOutputStream out = new DataOutputStream(httpUrlConn.getOutputStream());

			String content = "email=" + email;

			out.writeBytes(content);

			out.flush();
			out.close();

			StringBuffer buffer = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream()));

			out.flush();
			out.close();
			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			httpUrlConn.disconnect();
			Application.logger.debug(buffer.toString());
			JSONObject jsonObject = new JSONObject(buffer.toString());
			JSONArray jSONArray = jsonObject.optJSONArray("items");
			if(jSONArray!=null && jSONArray.length()>0){
				return true;
			}else{
				return false;
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public JSONObject getAdminOauthToken() throws Exception {
		try {
			URL url = new URL("");
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);

			httpUrlConn.setRequestProperty("Pragma", "no-cache");
			httpUrlConn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			httpUrlConn.setRequestProperty("accept", "application/json");
			httpUrlConn.setRequestProperty("Cache-Control", "no-cache");
			httpUrlConn.setRequestProperty("authorization", "Basic YWRtaW46c2VjcmV0LWV4cGxvcmU="); //
			httpUrlConn.setRequestProperty("Connection", "keep-alive");

			httpUrlConn.setRequestMethod("POST");

			httpUrlConn.connect();

			DataOutputStream out = new DataOutputStream(httpUrlConn.getOutputStream());

			String content = "grant_type=client_credentials";

			out.writeBytes(content);

			out.flush();
			out.close();

			StringBuffer buffer = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream()));

			out.flush();
			out.close();
			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			httpUrlConn.disconnect();
			Application.logger.debug(buffer.toString());
			JSONObject jsonObject = new JSONObject(buffer.toString());
			return jsonObject;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public String httpsRequest(String requestUrl, String method, String outputStr, Map<String, String> headers)
			throws Exception {
		try {
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			
			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);
			
			if (null != headers) {
				for (String key : headers.keySet()) {
					httpUrlConn.setRequestProperty(key, headers.get(key));
				}
			}

			if (!method.equals("GET")) {
				httpUrlConn.setDoOutput(true);
				httpUrlConn.setDoInput(true);
			}

			httpUrlConn.setRequestMethod(method);
			httpUrlConn.connect();

			if (outputStr != null) {
				DataOutputStream out = new DataOutputStream(httpUrlConn.getOutputStream());
				out.writeBytes(outputStr);
				out.flush();
				out.close();
			}

			StringBuffer buffer = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			
			httpUrlConn.disconnect();
			return buffer.toString();
		} catch (Exception ex) {
			throw ex;
		}
	}
}
