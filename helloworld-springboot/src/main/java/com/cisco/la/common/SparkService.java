/**
 * 
 */
package com.cisco.la.common;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.cisco.la.Application;
import com.cisco.la.Application.Env;
import com.google.gson.Gson;

/**
 * @author P9030576
 *
 */
@Service
public class SparkService {
//	public void sendMessage(String email, String message){
//		if(Application.envCurrent == Env.local){
//			return;
//		}
//		String urlSendMessage = "https://api.ciscospark.com/v1/messages";
//		try {
//			Pattern r = Pattern.compile("\\s");
//			Matcher m = r.matcher(message);
//			message = m.replaceAll(" ");
//			
//			JSONObject request = new JSONObject();
//			request.put("toPersonEmail", email);
//			request.put("text", message);
//			
//			Map<String, String> headers = new HashMap<String, String>();
//			headers.put("content-type", "application/json; charset=utf-8");
//			headers.put("authorization", "Bearer " + Application.boltToken);
//			
//			httpsConnection(urlSendMessage,"POST",request.toString(), headers);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}
	
	public void sendMarkdownMessage(String email, String message){
		Application.logger.debug("sendMarkdownMessage");
		Application.logger.debug(email);
		Application.logger.debug(message);
		if(Application.envCurrent == Env.local){
			return;
		}
		String urlSendMessage = "https://api.ciscospark.com/v1/messages";
		try {
			Pattern r = Pattern.compile("\\s");
			Matcher m = r.matcher(message);
			message = m.replaceAll(" ");
			
			JSONObject request = new JSONObject();
			request.put("toPersonEmail", email);
			request.put("markdown", message);
			
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("content-type", "application/json; charset=utf-8");
			headers.put("authorization", "Bearer " + Application.boltToken);
			
			httpsConnection(urlSendMessage,"POST",request.toString(), headers);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public Map<String, Object> getSparkPeople(String email) throws Exception{
		String urlGetPeople = "https://api.ciscospark.com/v1/people?email=" + email;
		try {
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("content-type", "application/json; charset=utf-8");
			headers.put("authorization", "Bearer " + Application.boltToken);
			
			JSONObject jsonObject = httpsConnection(urlGetPeople,"GET",null, headers);
			JSONArray jSONArray = jsonObject.optJSONArray("items");
			if(jSONArray!=null && jSONArray.length()>0){
				JSONObject infoJson = jSONArray.getJSONObject(0);
				String id = infoJson.getString("id");
				
				Map<String, Object> code = new HashMap<String, Object>();
				code.put("code", 1);
				code.put("id", id);
				return code;
			}else{
				Map<String, Object> code = new HashMap<String, Object>();
				code.put("code", -1);
				return code;
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public boolean checkSparkPeople(String email) throws Exception{
		String urlGetPeople = "https://api.ciscospark.com/v1/people?email=" + email;
		try {
			
			Map<String, String> headers = new HashMap<String, String>();
			headers.put("content-type", "application/json; charset=utf-8");
			headers.put("authorization", "Bearer " + Application.boltToken);
			
			JSONObject jsonObject = httpsConnection(urlGetPeople,"GET",null, headers);
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
	
	public JSONObject httpsConnection(String requestUrl, String method, String outputStr, Map<String, String> headers)
			throws Exception {
		try {
			String strResult = httpsRequest(requestUrl,method,outputStr,headers);
			JSONObject jsonObject = new JSONObject(strResult);
			return jsonObject;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public String httpsRequest(String requestUrl, String method, String outputStr, Map<String, String> headers)
			throws Exception {
		Gson gson = new Gson();

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
