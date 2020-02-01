package com.utility;

import org.codehaus.jackson.map.ObjectMapper;

public class UtilityJson {
	
	private static final ObjectMapper obj = new ObjectMapper();

	public static Object getObjectFromJSON(String jsonString, Class<?> className) {
	
		Object readValue = null;

		try
		{
			readValue = obj.readValue(jsonString, className);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return readValue;

	}

	public static Object getJSONFromObject(Object object) {
		
		String jsondata = null;

		try
		{
			jsondata = obj.writeValueAsString(object);
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}

		return jsondata;
	}
}
