package com.abc.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.abc.bean.Card;
import com.fasterxml.jackson.core.JsonParser;

@Transactional
@Service
public class CardService {

	private final String USER_AGENT = "Mozilla/67.0.1";

	public boolean validateCard(Card card) {
		String uri = "http://localhost:9203/details/";
		boolean valid = false;
		Map<Object, Object> jsonMap = new HashMap<>();

		// call RestFul web service with url
		// http://localhost:9203/details/cardNo/name/cvv

		uri += card.getCardNo() + "/" + card.getName() + "/" + card.getCvv();
		System.out.println("uri : " + uri);
		String delim = System.getProperty("line.separator");

		try {

			URL url = new URL(uri);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine = "";
			StringBuilder response = new StringBuilder();
			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine + delim);

			}
			reader.close();
			String val = response.toString();
			System.out.println("Val : " + val);
			jsonMap = getJasonMap(val);

			System.out.println("JsonMap : " + jsonMap);
			Long cvvVal= (Long) jsonMap.get("cvv");
			
			// JsonMap : {cvv=0, name=null, cardNo=1234123412341234}
			
			
			
			if(jsonMap.get("name")!=null  || jsonMap.get("expiry")!=null && cvvVal!=0)
			{
				valid =true;
				
			}

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return valid;
	}

	private Map<Object, Object> getJasonMap(String val) {

		Map<Object, Object> keyMap = new HashMap<>();
		JSONParser parser = new JSONParser();
		try {
			JSONObject obj = (JSONObject) parser.parse(val);
			Set<String> keySet = obj.keySet();
			for (Object keyObj : keySet) {

				Object jObj = obj.get(keyObj);
				
				
				if (jObj instanceof JSONObject) {
					JSONObject jsonObj = (JSONObject) jObj;
					Set<String>keySetInner =jsonObj.keySet();
					HashMap<Object, Object>innerMap= new HashMap<>();
					for(Object keyObjInner:keySetInner)
					{
						
						Object jsonObjInner=jsonObj.get(keyObjInner);
						innerMap.put(keyObjInner, jsonObjInner);
					}
					keyMap.put(keyObj, innerMap);

				}

				else if (jObj instanceof JSONArray) {
					JSONArray jsonArr = (JSONArray) jObj;
					if(jsonArr.size()>0)
					{
						JSONObject jsonObjArr= (JSONObject) jObj;
						System.out.println("json arr obj : " +jsonObjArr);
						Set<String> keySetInnerArr= jsonObjArr.keySet();
						HashMap<Object, Object>innerMap = new HashMap<>();
						for(Object keyObjectInnerArr: keySetInnerArr)
						{
							
							Object jsonObjInnerArr= jsonObjArr.get(keyObjectInnerArr);
							innerMap.put(keyObjectInnerArr, jsonObjInnerArr);
						}
						keyMap.put(keyObj, innerMap);
						
					}
					

				} else {
					keyMap.put(keyObj, jObj);

				}

			}
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return keyMap;

	}

}
