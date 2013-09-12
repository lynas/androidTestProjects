package com.example.testdb;

/*
 *  This class is used as a webservice communicator. It will communicate with the 
 *  webservice with a line of contracts seperated by coma (,) and receive the list
 *  that is available in the database of mysql db. The list is the active user list
 *  
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.util.Log;

public class DBConnection {
	private HttpClient httpclient;
	private HttpPost httpPost;
	private HttpResponse httpResponse;
	private HttpEntity httpEntity;

	private String returnMsg = "";

	/*
	 * This method sending the list containing all the number in the user phone
	 * and receive only those number available in the db
	 */
	public String getInfoFromDB(String givenList) {

		httpclient = new DefaultHttpClient();
		httpPost = new HttpPost(
				"http://10.0.2.2/getExitingUserAndAddInFriendList.php?list="
						+ givenList);
		try {

			httpResponse = httpclient.execute(httpPost);

			if (httpResponse.getStatusLine().getStatusCode() == 200) {

				httpEntity = httpResponse.getEntity();

				if (httpEntity != null) {
					InputStream instream = httpEntity.getContent();

					BufferedReader reader = new BufferedReader(
							new InputStreamReader(instream, "UTF-8"));

					StringBuilder sb = new StringBuilder();

					String line = null;

					while ((line = reader.readLine()) != null) {
						sb.append(line + "\n");
					}

					String result = sb.toString();
					JSONObject json = new JSONObject(result);

					Log.wtf("tag", result);

					// JSONObject jsonresponse = new JSONObject(
					// convertSteamToString(instream));

					String receivedList = json.getString("res");

					String[] test = receivedList.split(",");

					for (String t : test) {
						Log.wtf("tag", t.trim());
					}

					returnMsg = receivedList;

					instream.close();
				}

			}
		} catch (Exception e) {
			returnMsg = "Failed" + e.toString();
		}

		return returnMsg;

	}

	public String getInfoFromDB2(String givenList, String currentUser) {
		Log.wtf("list", givenList);
		Log.wtf("list", currentUser);

		httpclient = new DefaultHttpClient();
		httpPost = new HttpPost(
				"http://10.0.2.2/getExitingUserAndAddInFriendList.php?list="+ givenList + "&currentUser=" + currentUser);
		try {

			httpResponse = httpclient.execute(httpPost); 
			returnMsg = "s" + httpResponse.getStatusLine().getStatusCode(); 
			Log.d("ss", "s" + httpResponse.getStatusLine().getStatusCode());
		} catch (Exception e) {
			returnMsg = "Failed" + e.toString(); 
		}

		return returnMsg;

	}

}
